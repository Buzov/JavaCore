package Kalkulator;
import javax.swing.JFrame;


public class dlc {
	public static void main(String[] args) {
		Reader r = new Reader("Калькулятор");
	r.setVisible(true);
	r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	r.setSize(200, 200);
	r.setResizable(false);
	r.setLocationRelativeTo(null);
	}
}
