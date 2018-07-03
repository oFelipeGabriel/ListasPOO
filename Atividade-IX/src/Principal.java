import javax.swing.JFrame;
import javax.swing.JPanel;

public class Principal {

	public static void main(String[] args) {
		Um um = new Um();
		Dois dois = new Dois();
		JPanel p = new JPanel();
		JFrame frame = new JFrame("Rects");
		frame.add(dois);
		frame.setVisible(true);
		
	}

}
