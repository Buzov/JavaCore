package MyGame;

import javax.swing.*;

import java.awt.*;

@SuppressWarnings("serial")
public class JFrameGame  extends JFrame
{
		
	
	/**
	 * 
	 */
	String s;
	int x, y, w, h;
	public  JFrameGame(String ss, int xx, int yy, int ww, int hh)
	{
		s=ss;
		x=xx;
		y=yy;
		w=ww;
		h=hh;
		//super(s);
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();
		int lx=screenSize.width;
		int ly=screenSize.height;
		setBounds(x*lx/100-w/2,y*ly/100-h/2,w,h);
		MyPanel panel=new MyPanel();
		panel.setLayout(null);
		//изменение цвета фона
		//panel.setBackground(Color.blue);
		//получение клиентской части
		Container pane=getContentPane();
		pane.add(panel);
		
		
		
	}//public  JFrameGame(String s)
}//public class JFrameGame  extends JFrame
	

