package Chapter_8;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

class Terminator extends WindowAdapter {

	public void windowClosing(WindowEvent e)
	{
		System.out.println("window close test work!");
		QuitFrame quitFrame = new QuitFrame();
		
		
				
		quitFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		quitFrame.show();
		
	}
}
