package KeyAction;

import java.awt.Container;

import javax.swing.*;



class KeyTestFrame extends JFrame {
	public int Frame_HEIGHT = 300;
	public int Frame_WIDTD = 300;
	
	public KeyTestFrame()
	{
		setTitle("KeyActionTest");
		setSize(Frame_WIDTD,Frame_HEIGHT);
		
		KeyTestPanel panel = new KeyTestPanel();
		Container contentPane = getContentPane();
		contentPane.add(panel);	
		
		
	}
	
}
