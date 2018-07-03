import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Dois extends JFrame implements ActionListener{
	private JButton j1,j2,j3,j4,j5,j6,j7,j8,j9,j0,jMais,jMenos,jDiv,jMult,jIgual,jAC;
	private int contador = 0 ;
	private JLabel resultado;
	private JLabel operacao;
	private int op;
	private JTextField entrada1;
	private JTextField entrada2;
	public Dois() {
		super("Exemplo de JButtons e Eventos");
		Container c = getContentPane();
		c.setLayout(new GridLayout(5,4));
		entrada1 = new JTextField();
		entrada2 = new JTextField();
		entrada1.setHorizontalAlignment(JTextField.CENTER);
		entrada2.setHorizontalAlignment(JTextField.CENTER);
		operacao = new JLabel();
		operacao.setHorizontalAlignment(JLabel.CENTER);
		resultado = new JLabel();
		resultado.setHorizontalAlignment(JLabel.CENTER);
		j1 = new JButton("1");
		j2 = new JButton("2");
		j3 = new JButton("3");
		j4 = new JButton("4");
		j5 = new JButton("5");
		j6 = new JButton("6");
		j7 = new JButton("7");
		j8 = new JButton("8");
		j9 = new JButton("9");
		j0 = new JButton("0");
		jMais = new JButton("+");
		jMenos = new JButton("-");
		jMult = new JButton("*");
		jDiv = new JButton("/");
		jIgual = new JButton("=");
		jAC = new JButton("AC");
		setSize(800,800);
		c.add(entrada1);c.add(operacao);c.add(entrada2);c.add(resultado);
		c.add(j7);c.add(j8);c.add(j9);c.add(jMult);
		c.add(j4);c.add(j5);c.add(j6);c.add(jDiv);
		c.add(j1);c.add(j2);c.add(j3);c.add(jMenos);
		c.add(jAC);c.add(j0);c.add(jIgual);c.add(jMais);
		j1.addActionListener(this); j2.addActionListener(this);j3.addActionListener(this);
		j4.addActionListener(this); j5.addActionListener(this);j6.addActionListener(this);
		j7.addActionListener(this); j8.addActionListener(this);j9.addActionListener(this);
		j0.addActionListener(this); jMais.addActionListener(this);jMenos.addActionListener(this);
		jDiv.addActionListener(this); jMult.addActionListener(this);jAC.addActionListener(this);
		jIgual.addActionListener(this);
		pack();
		setVisible(true);
		setDefaultCloseOperation(3);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == j1 && operacao.getText().equals("")) {entrada1.setText(entrada1.getText()+"1");;}
		else if(e.getSource() == j1 && !operacao.getText().equals("")) entrada2.setText(entrada2.getText()+"1");
		else if(e.getSource() == j2 && operacao.getText().equals("")) entrada1.setText(entrada1.getText()+"2");
		else if(e.getSource() == j2 && !operacao.getText().equals("")) entrada2.setText(entrada2.getText()+"2");
		else if(e.getSource() == j3 && operacao.getText().equals("")) entrada1.setText(entrada1.getText()+"3");
		else if(e.getSource() == j3 && !operacao.getText().equals("")) entrada2.setText(entrada2.getText()+"3");
		else if(e.getSource() == j4 && operacao.getText().equals("")) entrada1.setText(entrada1.getText()+"4");
		else if(e.getSource() == j4 && !operacao.getText().equals("")) entrada2.setText(entrada2.getText()+"4");
		else if(e.getSource() == j5 && operacao.getText().equals("")) entrada1.setText(entrada1.getText()+"5");
		else if(e.getSource() == j5 && !operacao.getText().equals("")) entrada2.setText(entrada2.getText()+"5");
		else if(e.getSource() == j6 && operacao.getText().equals("")) entrada1.setText(entrada1.getText()+"6");
		else if(e.getSource() == j6 && !operacao.getText().equals("")) entrada2.setText(entrada2.getText()+"6");
		else if(e.getSource() == j7 && operacao.getText().equals("")) entrada1.setText(entrada1.getText()+"7");
		else if(e.getSource() == j7 && !operacao.getText().equals("")) entrada2.setText(entrada2.getText()+"7");
		else if(e.getSource() == j8 && operacao.getText().equals("")) entrada1.setText(entrada1.getText()+"8");
		else if(e.getSource() == j8 && !operacao.getText().equals("")) entrada2.setText(entrada2.getText()+"8");
		else if(e.getSource() == j9 && operacao.getText().equals("")) entrada1.setText(entrada1.getText()+"9");
		else if(e.getSource() == j9 && !operacao.getText().equals("")) entrada2.setText(entrada2.getText()+"9");
		else if(e.getSource() == j0 && operacao.getText().equals("")) entrada1.setText(entrada1.getText()+"0");
		else if(e.getSource() == j0 && !operacao.getText().equals("")) entrada2.setText(entrada2.getText()+"0");

		else if(e.getSource() == jMais) {operacao.setText("+");op = 1;}
		else if(e.getSource() == jMenos) {operacao.setText("-");op = 2;}
		else if(e.getSource() == jDiv) {operacao.setText("/");op = 3;}
		else if(e.getSource() == jMult) {operacao.setText("*");op = 4;}
		else if(e.getSource() == jIgual) {
			if(op==1) resultado.setText(String.valueOf(Integer.parseInt(entrada1.getText())+Integer.parseInt(entrada2.getText())));
			if(op==2) resultado.setText(String.valueOf(Integer.parseInt(entrada1.getText())-Integer.parseInt(entrada2.getText())));
			if(op==3) resultado.setText(String.valueOf(Integer.parseInt(entrada1.getText())/Integer.parseInt(entrada2.getText())));
			if(op==4) resultado.setText(String.valueOf(Integer.parseInt(entrada1.getText())*Integer.parseInt(entrada2.getText())));
		}
		else if(e.getSource() == jAC) {
			entrada1.setText("");
			entrada2.setText("");
			operacao.setText("");
			resultado.setText("");
		}
	}
	
}
