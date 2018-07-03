
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;


@SuppressWarnings("serial")
public class Arena extends JComponent implements MouseListener, ActionListener,KeyListener{
	private Tanque apontado;
	private static Chat chat = new Chat();
	private int largura,altura;
	private ArrayList<Tanque> tanques;
	private ArrayList<Tiro> tiros;
	private Tiro tiro;
	private Timer contador;
	private long agora;
	private int idAtivo = 0;
	Thread t1 = new Thread(chat);
	
	
	public Arena(int largura,int altura){
		this.largura = largura; 
		this.altura = altura;
		tanques = new ArrayList<Tanque>();
		tiros = new ArrayList<Tiro>();
		tiro = new Tiro(-10, -10, 0, null,-1);
		addMouseListener(this);
		addKeyListener(this);
		setFocusable(true);
		contador = new Timer(40, this);
		contador.start();
		agora = 1;
		
		chat.setLayout(new GridLayout(20,1));
		JFrame nova = new JFrame("Chat");
		t1.start();
		nova.getContentPane();
		nova.add(chat);
		nova.setLocation(710, 100);
		nova.pack();
		nova.setVisible(true);
		nova.setDefaultCloseOperation(3);
		
	}
	
	public void adicionaTanque(Tanque t){		
		tanques.add(t);
		chat.addTanque(t);
		chat.atualizaTotal(tanques.size());
		chat.pintaBotoes(t.getId());
	}
	public void selecionaTanque(int t) {
		
		for(Tanque tanque:tanques) {
			if(t==tanque.getId()) {
				tanque.setEstaAtivo(true);
			}
		}
	}
	public Dimension getMaximumSize(){
		return getPreferredSize();
	}
	public Dimension getMinimumSize(){
		return getPreferredSize();
	}
	public Dimension getPreferredSize(){
		return new Dimension(largura,altura);
	}
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
		RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(new Color(245,245,255));
		g2d.fillRect(0,0,largura,altura);
		g2d.setColor(new Color(220,220,220));
		for(int _largura=0;_largura<=largura;_largura+=20)
			g2d.drawLine(_largura,0,_largura,altura);
		for(int _altura=0;_altura<=altura;_altura+=20) 
			g2d.drawLine(0,_altura,largura,_altura);
		// Desenhamos todos os tanques
		for(Tanque t:tanques) {
			t.draw(g2d);
		}
		for(Tiro tiro:tiros) {
			tiro.draw(g2d);
		}
	}
    public void mouseClicked(MouseEvent e){
		for(Tanque t:tanques) {
			if(t.estaAtivo==true) apontado=t;
			else t.setEstaAtivo(false);
		}
		/*for(Tanque t:tanques){
			 boolean clicado = t.getRectEnvolvente().contains(e.getX(),e.getY());
			/*if (clicado){
				t.setEstaAtivo(true);
				apontado=t;
			}
		}*/
		repaint();
	}
	public void mouseEntered(MouseEvent e) { }
	public void mouseExited(MouseEvent e) { }
	public void mousePressed(MouseEvent e) { }
	public void mouseReleased(MouseEvent e) { }
	
	public void actionPerformed(ActionEvent e){
		
		for(int i=0;i<tanques.size();i++){
			Tanque t = tanques.get(i);
			if(idAtivo!=0 && (int)t.getId()==idAtivo) {
				t.setEstaAtivo(true);
			}else t.setEstaAtivo(false);
			if(chat.getTipo().equals("Servidor")) {
				if(chat.tanquesAtivos.contains(t.getId())) {
					for(Tanque tanque:chat.tanques) {
						if(t.getId()==tanque.getId()) {
							t.x = tanque.x;
							t.y = tanque.y;
							t.angulo = tanque.angulo;
						}
					}
				}
				else {
					t.mover();
						try {
						chat.updateTanque(t);
					} catch (IOException e1) {}
					}
			}
			
			if(chat.getTipo().equals("Cliente")) {
				if(chat.getIdAtivo()==t.getId()) {
					t.mover();
					chat.mensagemEncaminhar = chat.tanqueToString(t);
					chat.clienteEncaminhaMsg();
				}
				else {
					for(Tanque tanque:chat.tanques) {
						if(t.getId()==tanque.getId()) {
							t.x = tanque.x;
							t.y = tanque.y;
							t.angulo = tanque.angulo;
						}
					}
				}
			t.calculaTempo();			
		}
		idAtivo = chat.getIdAtivo();
		try {
			colisao();
		} catch (IOException e1) {
			e1.printStackTrace();
		}		
		/*for(int k=0;k<chat.tiros.size();k++) {
			if(!tiros.contains(chat.tiros.get(k))){
				Tiro tr = new Tiro(chat.tiros.get(k).x,chat.tiros.get(k).y,chat.tiros.get(k).angulo,chat.tiros.get(k).getCor(),(int)chat.tiros.get(k).getId());
				tiros.add(tr);
				atirar((int)tr.getId());
				System.out.println("adicounou tiro: ");
			}
		}*/
		for(int y=0;y<tiros.size();y++) {
			Tiro tiro = tiros.get(y);
			tiro.mover();
		}
		repaint();
		}
	}
	public void colisao() throws IOException{
		if(!tiros.isEmpty()) {
			for(int j=0;j<tanques.size();j++){
				Tanque t = tanques.get(j);
				
				if(t.getId() != tiro.getId()){ 
					double dist = Math.sqrt(Math.pow(tiro.x - t.x, 2) + Math.pow(tiro.y - t.y, 2));
					if(dist <= 20){/*Distancia de acerto*/
						tiro.x = -10;
						tiro.y = -10;
						chat.atualizaCor(t.getId());
						tanques.remove(t);
						
						//encaminha mensagem que tanque foi atingido e deve ser removido
						String encaminhar = "remove;tanque;"+t.getId();
						if(chat.getTipo().equals("Cliente")) {
							chat.mensagemEncaminhar = encaminhar;
							chat.clienteEncaminhaMsg();
							chat.mensagemEncaminhar = "";
							chat.configurarRede();
							
						}else if(chat.getTipo().equals("Servidor")){
							chat.encaminharParaTodos(encaminhar);
						}
						
						tiro.estaAtivo = false;
						tiros.remove(tiro);
						chat.tanqueFora((int)t.getId());
						break;
					}
					/*Tanque detecta o m�ssil e tenta se esquivar*/
					if(dist < 100){
						t.setTempo(System.currentTimeMillis());
						
						if(agora%2 == 0)
							t.girarAntiHorario(7);
						else
							t.girarHorario(7);
						
						t.velocidade = 6;
					}					
					}				
				}		
					
		}
		
		for(int i=0;i<tanques.size();i++){
			Tanque t = tanques.get(i);
			autoColisao(t);
			if(tanques.size()==1) {
				JOptionPane.showMessageDialog(null, "Tanque "+chat.getCorTanque((int) t.getId())+" ganhou","JTank", 1);
				tanques.remove(t);
				}
			for(int j=0;j<chat.atingidosTanques.size();j++) {
				if(t.getId()==chat.atingidosTanques.get(j)) tanques.remove(t);
		}
		}
}
	public void autoColisao(Tanque tanque){
		for(Tanque t : tanques){/*verifica a distancia para checar colis�o entre os  tanques*/
			if(tanque.getId() != t.getId()){
				double dist = Math.sqrt(Math.pow(tanque.x - t.x, 2) + Math.pow(tanque.y - t.y, 2));
				if(dist <= 30){ /*Colis�o entre tanques*/
					if(t.velocidade > 0){
						t.velocidade *= -1;
						t.girarAntiHorario(7);
					}
					else{
						t.velocidade = 2;
					    t.girarHorario(7);
					}
				}
				
				if(dist < 80 &&  tanque.estaAtivo){/*tanque inimigo tenta fugir*/
					t.setTempo(System.currentTimeMillis());
					if(agora%2 == 0)
						t.girarAntiHorario(5);
					else
						t.girarHorario(5);
					
					t.velocidade = 6;
				}
				
			}
		}
	}


	public  void keyPressed(KeyEvent e) {
		for(Tanque t:tanques){
			t.setEstaAtivo(false);			
			if(t==apontado){
				t.setEstaAtivo(true);
				switch(e.getKeyCode()){
			    case KeyEvent.VK_LEFT: t.girarAntiHorario(5); break;
		        case KeyEvent.VK_UP: t.aumentarVelocidade(); break;
		        case KeyEvent.VK_DOWN : t.diminuirVelocidade(); break;
				case KeyEvent.VK_RIGHT: t.girarHorario(5); break;
				case KeyEvent.VK_SPACE: 
				{
					atirar((int) t.getId());
					agora = System.currentTimeMillis();
				}break;
			}
				
			break;
			}
			repaint();
		}
		
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
	}
	
	public void atirar(int id){
		for(Tanque t:tanques){
			if(t.estaAtivo){
				tiro = new Tiro(t.x, t.y, t.angulo, Color.red, (int) t.getId());
				 
				if(! tiro.estaAtivo){				
					if(tiro.angulo>=0 && tiro.angulo<=90) {tiro.y=(t.angulo/3-30)+t.y;tiro.x=(t.angulo/3)+t.x;}
					if(tiro.angulo>90 && tiro.angulo<=180) {tiro.y=((t.angulo-90)/3)+t.y;tiro.x=(30-(t.angulo-90)/3)+t.x;}
					if(tiro.angulo>180 && tiro.angulo<=270) {tiro.y=(30-(t.angulo-180)/3)+t.y;tiro.x=(-(t.angulo-180)/3)+t.x;}
					if(tiro.angulo>270 && tiro.angulo<=360) {tiro.y=(-(t.angulo-270)/3)+t.y;tiro.x=-(30-(t.angulo-270)/3)+t.x;}										
					tiro.estaAtivo = true;
					/*
					 * tiros.add(tiro);
					 * chat.tiros.add(tiro);
					 */
					if(chat.getTipo().equals("Servidor")) {
						tiros.add(tiro);
						chat.tiros.add(tiro);
						chat.encaminharParaTodos(tiro.posicoes());
					}
					else if(chat.getTipo().equals("Cliente")) {
						chat.mensagemEncaminhar = tiro.posicoes();
						chat.clienteEncaminhaMsg();
						tiros.add(tiro);
						
					}
				}
			}
		}
		
		}

	public static void main(String args[]){
		Arena arena = new Arena(640,480);
		arena.adicionaTanque(new Tanque(ThreadLocalRandom.current().nextInt(0, 600),ThreadLocalRandom.current().nextInt(0, 400),ThreadLocalRandom.current().nextInt(0, 360),Color.BLUE,1));
		arena.adicionaTanque(new Tanque(ThreadLocalRandom.current().nextInt(0, 600),ThreadLocalRandom.current().nextInt(0, 400),ThreadLocalRandom.current().nextInt(0, 360),Color.RED,2));
		arena.adicionaTanque(new Tanque(ThreadLocalRandom.current().nextInt(0, 600),ThreadLocalRandom.current().nextInt(0, 400),ThreadLocalRandom.current().nextInt(0, 360),Color.GREEN,3));
		arena.adicionaTanque(new Tanque(ThreadLocalRandom.current().nextInt(0, 600),ThreadLocalRandom.current().nextInt(0, 400),ThreadLocalRandom.current().nextInt(0, 360),Color.YELLOW,4));
		arena.adicionaTanque(new Tanque(ThreadLocalRandom.current().nextInt(0, 600),ThreadLocalRandom.current().nextInt(0, 400),ThreadLocalRandom.current().nextInt(0, 360),Color.BLACK,5));
		arena.adicionaTanque(new Tanque(ThreadLocalRandom.current().nextInt(0, 600),ThreadLocalRandom.current().nextInt(0, 400),ThreadLocalRandom.current().nextInt(0, 360),Color.WHITE,6));
		arena.adicionaTanque(new Tanque(ThreadLocalRandom.current().nextInt(0, 600),ThreadLocalRandom.current().nextInt(0, 400),ThreadLocalRandom.current().nextInt(0, 360),Color.CYAN, 7));
		arena.adicionaTanque(new Tanque(ThreadLocalRandom.current().nextInt(0, 600),ThreadLocalRandom.current().nextInt(0, 400),ThreadLocalRandom.current().nextInt(0, 360),Color.ORANGE,8));
		
		JFrame janela = new JFrame("JTank");
		
		arena.selecionaTanque(chat.selecionado);
		janela.getContentPane();
		janela.add(arena);
		janela.setResizable(false);
		janela.pack();
		janela.setVisible(true);
		janela.setDefaultCloseOperation(3);
		
	
	}


	
	
	
}