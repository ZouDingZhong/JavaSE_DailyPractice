package Chapter_8;

import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class ButtonTest {

	public static void main(String[] args) {
		// TODO Auto-generated constructor stub
		MyFrame f = new MyFrame();
		
		WindowListener listener = new Terminator();
		f.addWindowListener(listener);
		
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.show();
	}

}
