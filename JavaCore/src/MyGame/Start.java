package MyGame;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Start {
	@SuppressWarnings("deprecation")
	public static void main(String args[]) {
		JFrameGame frame = new JFrameGame("Dart", 50, 50, 650, 370);
		frame.setTitle("Виселица");
		frame.setResizable(false);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image im = kit.getImage("dartvejder.jpg");
		frame.setIconImage(im);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.show();

	}

}
