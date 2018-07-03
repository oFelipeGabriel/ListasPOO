import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

public class VerMensagens extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	JButton next = new JButton(">");
	JButton prev = new JButton("<");
	JLabel title = new JLabel();
	JLabel msg1 = new JLabel();
	JLabel msg2 = new JLabel();
	JLabel msg3 = new JLabel();
	JLabel msg4 = new JLabel();
	JLabel msg5 = new JLabel();
	JLabel msg6 = new JLabel();
	JLabel msg7 = new JLabel();
	JLabel msg8 = new JLabel();
	JLabel msg9 = new JLabel();
	JLabel msg10 = new JLabel();
	JPanel head = new JPanel();
	ArrayList<Mensagens> msgs = new ArrayList<>();
	int i = 0;
	int indice;
	
	ObjectContainer mensagensSalvas;
	
	public VerMensagens() {
		head.add(prev);
		head.add(title);
		head.add(next);
		add(head);
		add(msg1); add(msg2); add(msg3); add(msg4); add(msg5);
		add(msg6); add(msg7); add(msg8); add(msg9); add(msg10);
		next.addActionListener(this);
		prev.addActionListener(this);
		setLayout(new GridLayout(11,1));
		recuperaDados();
	}
	
	public void recuperaDados() {
		mensagensSalvas = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "mensagens.db4o");
		
		Query query = mensagensSalvas.query();
		query.constrain(Mensagens.class);
	    ObjectSet<Mensagens> allMsg = query.execute();
	    for(Mensagens m:allMsg) {
	    	Mensagens message = new Mensagens();
	    	msgs.add(message);
	    	msgs.get(i).setData(m.getData());
	    	msgs.get(i).setMensagens(m.getMensagens());
	    	i++;
	    }
	    i = 0;
	    atualizaDados(0);
	    mensagensSalvas.close();
	}
	public void atualizaDados(int index) {
		if(msgs.size()>0) {title.setText(msgs.get(index).getData());
	    msg1.setText(msgs.get(index).getMensagens().get(0));
	    if(msgs.get(index).getMensagens().size()>1) msg2.setText(msgs.get(index).getMensagens().get(1));
	    if(msgs.get(index).getMensagens().size()>2) msg3.setText(msgs.get(index).getMensagens().get(2));
	    if(msgs.get(index).getMensagens().size()>3) msg4.setText(msgs.get(index).getMensagens().get(3));
	    if(msgs.get(index).getMensagens().size()>4) msg5.setText(msgs.get(index).getMensagens().get(4));
	    if(msgs.get(index).getMensagens().size()>5) msg6.setText(msgs.get(index).getMensagens().get(5));
	    if(msgs.get(index).getMensagens().size()>6) msg7.setText(msgs.get(index).getMensagens().get(6));
	    if(msgs.get(index).getMensagens().size()>7) msg8.setText(msgs.get(index).getMensagens().get(7));
	    if(msgs.get(index).getMensagens().size()>8) msg9.setText(msgs.get(index).getMensagens().get(8));
	    if(msgs.get(index).getMensagens().size()>9) msg10.setText(msgs.get(index).getMensagens().get(9));
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==prev && indice>0) {
			atualizaDados(i-1);
			i = i-1;
			if(i==0) i=1;
		}
		if(e.getSource()==next && msgs.size()>i+1) {
			atualizaDados(i+1);
			i = i + 1;
		}
		}
		
	
}
