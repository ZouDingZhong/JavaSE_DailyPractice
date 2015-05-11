package Chapter_8;

import java.awt.Container;
import java.awt.event.WindowListener;

import javax.swing.*;;

class MyFrame extends JFrame {
	public int Frame_HEIGHT = 300;
	public int Frame_WIDTD = 300;
	
	public MyFrame()
	{
		setTitle("ButtonTest");
		setSize(Frame_WIDTD,Frame_HEIGHT);
		
		MyPanel panel = new MyPanel();
		Container contentPane = getContentPane();
		contentPane.add(panel);	
		
		
	}
	

}
