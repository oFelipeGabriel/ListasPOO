import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;


public class Chat extends JPanel implements MouseListener,ActionListener,Runnable{
	private static final long serialVersionUID = 1L;
	VerMensagens verMensagens = new VerMensagens();
	ArrayList<Tanque> tanques = new ArrayList<>();
	ArrayList<Tiro> tiros = new ArrayList<>();
	ArrayList<Long> tanquesAtivos = new ArrayList<>();
	Tanque t;
	Tiro tiro;
	int largura;
	int altura;
	int total = 0;
	int selecionado = 0;
	String nick;
	String[] tq;
	private String tipo;
	private String texto = "Conectado";
	private int idAtivo = 0;
	private int id = 0;
	private ServerSocket server;
	private Socket socketCliente;
	String ip = null;
	public final String[] coresTanques = {"Azul", "Vermelho", "Verde", "Amarelo", "Cinza", "Branco", "Ciano", "Laranja"}; 
	PrintWriter escritor = null;
	Scanner leitor;
	Object sIp;
	List<PrintWriter> escritores = new ArrayList<>();
	ArrayList<Long> atingidosTanques = new ArrayList<>();
	ArrayList<String> mensagensCliente = new ArrayList<>();
	String mensagemEncaminhar = "";

	JLabel label = new JLabel();
	JButton azul = new JButton("Azul");
	JButton verm = new JButton("Vermelho");
	JButton verd = new JButton("Verde");
	JButton amar = new JButton("Amarelo");
	JButton cinz = new JButton("Cinza");
	JButton bran = new JButton("Branco");
	JButton cian = new JButton("Ciano");
	JButton lara = new JButton("Laranja");
	JLabel labelChat = new JLabel();
	JLabel labelChat1 = new JLabel();
	JLabel labelChat2 = new JLabel();
	JLabel labelChat3 = new JLabel();
	JLabel labelChat4 = new JLabel();
	JLabel labelChat5 = new JLabel();
	JLabel labelChat6 = new JLabel();
	JLabel labelChat7 = new JLabel();
	JLabel labelChat8 = new JLabel();
	JLabel labelChat9 = new JLabel();
	JLabel labelChat0 = new JLabel();
	ArrayList<JLabel> labels = new ArrayList<>();
	ArrayList<String> mensagens = new ArrayList<>();

	JTextField msg = new JTextField();
	JButton envia = new JButton("Enviar");
	JPanel conteudo = new JPanel();
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();

	JLabel conect = new JLabel(); 
	JLabel seuNome = new JLabel();
	String[] opcoes = {"Servidor", "Cliente"};
	JButton ok = new JButton("OK");
	JLabel digite = new JLabel("Digite seu nome:");
	JTextField txt = new JTextField(10);
	JPanel init = new JPanel();
	
	JButton gravar = new JButton("Gravar");
	JButton recuperar = new JButton("Ver mensagens gravadas");
	JPanel gravados = new JPanel();
	
	ObjectContainer mensagensSalvas;// = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "mensagens.db4o");;

	public Chat() {
		labels.add(labelChat);labels.add(labelChat1);labels.add(labelChat2);
		labels.add(labelChat3);labels.add(labelChat4);labels.add(labelChat5);
		labels.add(labelChat6);labels.add(labelChat7);labels.add(labelChat8);
		labels.add(labelChat9);labels.add(labelChat0);
		Object selected = JOptionPane.showInputDialog(null, 
				"Você é Servidor ou Cliente?", "Selecione", 
				JOptionPane.DEFAULT_OPTION, null, opcoes, "0");
		if ( selected != null ) {
			setTipo(selected.toString());
			labelChat.setText("Você está como "+getTipo());}
		if(getTipo().equals("Cliente")) {
			Object conectarServ = JOptionPane.showInputDialog(null, 
					"Digite o ip do servidor", "IP");		
			if ( conectarServ != null ) {
				setIp(conectarServ.toString());
				conect.setText("Conectado a "+getIp());				
				}
		}
		else conect.setText("Conectado como servidor");
		Object getNick = JOptionPane.showInputDialog(null, 
				"Digite seu NICKNAME", "Nick");		
		if ( getNick != null ) {
			nick = getNick.toString();
			}
		add(conect);

		panel1.setLayout(new GridLayout(1,4));
		panel2.setLayout(new GridLayout(1,4));
		setBackground(Color.lightGray);
		addMouseListener(this);
		azul.addActionListener(this);
		verm.addActionListener(this);
		verd.addActionListener(this);
		amar.addActionListener(this);
		cinz.addActionListener(this);
		bran.addActionListener(this);
		cian.addActionListener(this);
		lara.addActionListener(this);
		envia.addActionListener(this);
	

	panel1.add(azul);
	panel1.add(verm);
	panel1.add(verd);
	panel1.add(amar);
	panel2.add(cinz);
	panel2.add(bran);
	panel2.add(cian);
	panel2.add(lara);

	add(panel1);
	add(panel2);
	add(label);
	add(msg);
	add(envia);
	add(labelChat);
	add(labelChat1);
	add(labelChat2);
	add(labelChat3);
	add(labelChat4);
	add(labelChat5);
	add(labelChat6);
	add(labelChat7);
	add(labelChat8);
	add(labelChat9);
	add(labelChat0);
	mensagensCliente.add("");
	
	gravados.add(gravar);
	gravados.add(recuperar);
	gravar.addActionListener(this);
	recuperar.addActionListener(this);
	add(gravados);
	}

public void definirTanque(int id) {
	setIdAtivo(id);
	mensagens.add("Tanque "+coresTanques[id-1]);
	atualizaChat();
	setTexto(Integer.toString(id));
}	
public void tanqueFora(int id){
	String txt = "";
	if(id!=0)txt = "Tanque "+coresTanques[id-1]+" perdeu";
	mensagens.add(txt);
	atualizaChat();
	atualizaTotal(tanques.size());
	
}

public void atualizaTotal(Integer t) {
	label.setText("Total: "+Integer.toString(t));
}
public void pintaBotoes(long l) {
	switch((int)l) {
	case 1:azul.setBackground(Color.blue);azul.setForeground(Color.white);break;
	case 2:verm.setBackground(Color.red);verm.setForeground(Color.white);break;
	case 3:verd.setBackground(Color.green);break;
	case 4:amar.setBackground(Color.yellow);break;
	case 5:cinz.setBackground(Color.gray);cinz.setForeground(Color.white);break;
	case 6:bran.setBackground(Color.white);break;
	case 7:cian.setBackground(Color.cyan);break;
	case 8:lara.setBackground(Color.orange);break;
	}
}
public void atualizaCor(long l) {
	switch((int)l) {
	case 1:azul.setBackground(Color.black);azul.setForeground(Color.gray);setEnabled(false);break;
	case 2:verm.setBackground(Color.black);verm.setForeground(Color.gray);setEnabled(false);break;
	case 3:verd.setBackground(Color.black);verd.setForeground(Color.gray);setEnabled(false);break;
	case 4:amar.setBackground(Color.black);amar.setForeground(Color.gray);setEnabled(false);break;
	case 5:cinz.setBackground(Color.black);cinz.setForeground(Color.gray);setEnabled(false);break;
	case 6:bran.setBackground(Color.black);bran.setForeground(Color.gray);setEnabled(false);break;
	case 7:cian.setBackground(Color.black);cian.setForeground(Color.gray);setEnabled(false);break;
	case 8:lara.setBackground(Color.black);lara.setForeground(Color.gray);setEnabled(false);break;
	}
}
public ArrayList<Tanque> getTanques() {
	return tanques;
}
public void setTanques(ArrayList<Tanque> tanques) {
	this.tanques = tanques;
}
public void addTanque(Tanque t) {
	tanques.add(new Tanque(t.x,t.y,t.angulo,t.getCor(),(int)t.getId()));
	if(getTipo().equals("Servidor")) {
		encaminharParaTodos("tanque;"+Double.toString(t.getId())+";"+Double.toString(t.x)
		+";"+Double.toString(t.y)+";"+Double.toString(t.angulo));
		System.out.println("tanque;"+Double.toString(t.getId())+";"+Double.toString(t.x)
		+";"+Double.toString(t.y)+";"+Double.toString(t.angulo));
	}
}
public void updateTanque(Tanque t) throws IOException {
	if(tanques.size()>0) {
		for(int i=0;i<tanques.size();i++) {
			Tanque tanque = tanques.get(i);
			if(t.getId()==tanque.getId()) {
				tanque.x=t.x;
				tanque.y=t.y;
				tanque.angulo=t.angulo;
				encaminharParaTodos(tanqueToString(t));
			}
		}
	}
}
public String tanqueToString(Tanque t) {
	String tanque = "";
	tanque += "tanque;";
	tanque += Long.toString(t.getId())+";";
	tanque += Double.toString(t.x)+";";
	tanque += Double.toString(t.y)+";";
	tanque += Double.toString(t.angulo)+";";
	return tanque;
}
public void updateTiros(Tiro tiro) throws IOException {
	if(tiros.size()>0) {
	for(Tiro t:tiros) {
		if(tiro.getId()==t.getId()) {
			tiro=t;
		}
	}
}}

public String getNick() {
	return nick;
}

public void setNick(String nick) {
	this.nick = nick;
}

public String getTipo() {
	return tipo;
}

public void setTipo(String tipo) {
	this.tipo = tipo;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getIp() {
	return ip;
}

public void setIp(String ip) {
	this.ip = ip;
}

public JTextField getMsg() {
	return msg;
}

public void setMsg(JTextField msg) {
	this.msg = msg;
}

public JTextField getTxt() {
	return txt;
}

public String getTexto() {
	return texto;
}

public void setTexto(String texto) {
	this.texto = texto;
}

public void setTxt(JTextField txt) {
	this.txt = txt;
}

public String[] getCoresTanques() {
	return coresTanques;
}

public int getIdAtivo() {
	return idAtivo;
}
public String getCorTanque(int id) {
	return coresTanques[id-1];
}

public void setIdAtivo(int idAtivo) {
	this.idAtivo = idAtivo;
}
public void atualizaChat() {
	if(mensagens.size()>10) {
		mensagens.remove(0);
	}
	if(mensagens.size()>0) labelChat.setText(mensagens.get(0));
	if(mensagens.size()>1) labelChat1.setText(mensagens.get(1));
	if(mensagens.size()>2) labelChat2.setText(mensagens.get(2));
	if(mensagens.size()>3) labelChat3.setText(mensagens.get(3));
	if(mensagens.size()>4) labelChat4.setText(mensagens.get(4));
	if(mensagens.size()>5) labelChat5.setText(mensagens.get(5));
	if(mensagens.size()>6) labelChat6.setText(mensagens.get(6));
	if(mensagens.size()>7) labelChat7.setText(mensagens.get(7));
	if(mensagens.size()>8) labelChat8.setText(mensagens.get(8));
	if(mensagens.size()>9) labelChat9.setText(mensagens.get(9));
	if(mensagens.size()>10) labelChat0.setText(mensagens.get(10));
	
}
	//Servidor de conexão
public void iniciarEscuta()throws Exception{
	if(tipo.equals("Servidor")) {
		try {
			server = new ServerSocket(1234);
			while(true) {
				Socket s = server.accept();
				new Thread(new EscutaCliente(s)).start();
				PrintWriter w = new PrintWriter(s.getOutputStream());
				escritores.add(w);
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	else {
		configurarRede();
	}
	//atualizaChat();
	}
public void configurarRede(){
	try {
	 socketCliente = new Socket(ip,1234);
	 escritor = new PrintWriter(socketCliente.getOutputStream());
	 leitor = new Scanner(socketCliente.getInputStream());
	 new Thread(new EscutaServidor()).start();
	}catch(Exception e) {}
}

private void setPosicoes(String[] tq) {
	String[] tnq = tq;
	if(tanques.size()>0 && tq !=null) {
		for(Tanque t:tanques) {
			if(t.getId()==Integer.parseInt(tnq[1]) && t.getId()!=id) {
				t.x=Double.parseDouble(tnq[2]);
				t.y=Double.parseDouble(tnq[3]);
				t.angulo=Double.parseDouble(tnq[4]);
			}
		}
	}
}
public void clienteEncaminhaMsg() {
	if(!mensagensCliente.isEmpty() && !mensagensCliente.get(mensagensCliente.size()-1).equals(mensagemEncaminhar)) {
		escritor.println(mensagemEncaminhar);
		escritor.flush();
		mensagensCliente.add(mensagemEncaminhar);
		mensagemEncaminhar = "";
	}	
}

	
@Override
public void run() {
	try {
		iniciarEscuta();
	} catch (Exception e) {}
	//atualizaChat();
}
@Override
public void mouseClicked(MouseEvent me) {
}

@Override
public void mouseEntered(MouseEvent e) {
}

@Override
public void mouseExited(MouseEvent e) {
}

@Override
public void mousePressed(MouseEvent e) {
}

@Override
public void mouseReleased(MouseEvent e) {
}

@Override
public void actionPerformed(ActionEvent e) {
	if(idAtivo==0) {
	if(e.getSource()==azul) definirTanque(1);
	if(e.getSource()==verm) definirTanque(2);
	if(e.getSource()==verd) definirTanque(3);
	if(e.getSource()==amar) definirTanque(4);
	if(e.getSource()==cinz) definirTanque(5);
	if(e.getSource()==bran) definirTanque(6);
	if(e.getSource()==cian) definirTanque(7);
	if(e.getSource()==lara) definirTanque(8);
	setTexto(msg.getText());
	}
	if(e.getSource()==envia) {
		if(tipo.equals("Servidor")) {
			encaminharParaTodos(nick+" diz: "+msg.getText());
			}
		else {				
			escritor.println(nick+" diz: "+msg.getText());
			escritor.flush();
			}
		mensagens.add(nick+" diz: "+msg.getText());	
		atualizaChat();
	}
	if(e.getSource()==gravar) {
		Mensagens m = new Mensagens();
		salvaMensagens(m);
	}
	if(e.getSource()==recuperar) {
		JFrame bd = new JFrame("Ver mensagens");
		bd.getContentPane();
		bd.setSize(300,300);
		bd.setLocation(710, 100);
		bd.add(verMensagens);
		bd.setVisible(true);
		bd.setDefaultCloseOperation(3);
	}
}

public void encaminharParaTodos(String texto) {
	for(int i=0;i<escritores.size();i++) {
		PrintWriter w = escritores.get(i);
		try {
			w.println(texto);
			w.flush();
		}catch(Exception e) {}
	}
	atualizaChat();
}
//Classe Escuta Cliente
private class EscutaCliente implements Runnable{
	Scanner leitor;
	public EscutaCliente(Socket socket) {		
		try {
			leitor = new Scanner(socket.getInputStream());
		} catch (Exception e) {}
	}
	public void run() {
		try {
		String texto;
		while((texto = leitor.nextLine()) != null) {
			/*if(texto.contains("msg")) {
				String[] txt = texto.split(":");
				mensagens.add("Enviado de: "+leitor+" : "
						+txt[1]);
			}*/
			if(texto.contains("tanque")){
				tq = texto.split(";");
				if(texto.contains("remove")) {
					for(int i=0;i<tanques.size();i++) {
						if(tanques.get(i).getId()==Long.parseLong(tq[2])) {
							tanques.remove(Integer.parseInt(tq[2]));
							atingidosTanques.add(Long.parseLong(tq[2]));
							tanqueFora(Integer.parseInt(tq[2]));
						}
					}
					encaminharParaTodos(texto);
				}
				else {
				if(!tanquesAtivos.contains(tq[1])) {
					tanquesAtivos.add(Long.parseLong(tq[1]));
				}
				}
				for(int i=0;i<tanques.size();i++) {
					Tanque t = tanques.get(i);
					if(t.getId()==Long.parseLong(tq[1])) {
						t.x = Double.parseDouble(tq[2]);
						t.y = Double.parseDouble(tq[3]);
						t.angulo = Double.parseDouble(tq[4]);
					}
				}
				}

			else if(texto.contains("tiro")) {
				double x,y,a;
				Color cor;
				int id;
				tq = texto.split(";");
				x = Double.parseDouble(tq[1]);
				y = Double.parseDouble(tq[2]);
				a = Double.parseDouble(tq[3]);
				cor = Color.black;
				id = Integer.parseInt(tq[4]);
				tiro = new Tiro(x,y,a,cor,id);
				tiros.add(tiro);
			}
			else {
				mensagens.add(texto);
				System.out.println("Recebeu: "+texto);
				atualizaChat();
			}
			
		}
		}catch (Exception e ) {}
	}
}
//Classe escuta servidor
private class EscutaServidor implements Runnable{
	
	public void run() {
		try {
		String texto;
		while((texto = leitor.next()) != null) {
			if(texto.contains("tanque")){
				tq = texto.split(";");
				if(texto.contains("remove")) {
					for(int i=0;i<tanques.size();i++) {
						if(tanques.get(i).getId()==Long.parseLong(tq[2])) {
							tanques.remove(i);
							atingidosTanques.add(Long.parseLong(tq[2]));
							tanqueFora(Integer.parseInt(tq[2]));
							configurarRede();
							break;
						}
					}
				}
				else setPosicoes(tq);			
				}
			else if(texto.contains("tiro")) {
				double x,y,a;
				Color cor;
				int id;
				tq = texto.split(";");
				x = Double.parseDouble(tq[1]);
				y = Double.parseDouble(tq[2]);
				a = Double.parseDouble(tq[3]);
				cor = Color.black;
				id = Integer.parseInt(tq[4]);
				tiro = new Tiro(x,y,a,cor,id);
				if(id!=idAtivo)	tiros.add(tiro);
			}
			else {
				mensagens.add(texto);
				atualizaChat();
			}
			
		}
		}catch(Exception e) {}
		
	}
}

//Banco de dados

public void salvaMensagens(Mensagens mensagens) {
	Calendar date = Calendar.getInstance();
	SimpleDateFormat s = new SimpleDateFormat("yyyy.MM.dd 'at' HH:mm:ss");
	String data = s.format(date.getTime());
	//mensagensSalvas.close();
	mensagensSalvas = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "mensagens.db4o");
	mensagens.setMensagens(this.mensagens);
	mensagens.setData(data);
	mensagensSalvas.store(mensagens);
	mensagensSalvas.commit();
	mensagensSalvas.close();
}


}


