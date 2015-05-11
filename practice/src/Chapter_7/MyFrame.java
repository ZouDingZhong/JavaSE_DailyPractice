package Chapter_7;

import java.awt.Color;
import java.awt.Container;

import javax.swing.*;

class MyFrame extends JFrame {

	public MyFrame()
	{
		setSize(WIDTH,HEIGHT);
		setTitle("PainTest");
		
		Mypanel panel = new Mypanel();
		panel.setBackground(Color.BLACK);
		Container contentPane = getContentPane();
		contentPane.add(panel);
	}
	public static int WIDTH = 600;
	public static int HEIGHT = 400;
}
