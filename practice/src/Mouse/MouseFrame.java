package Mouse;

import java.awt.Container;

import javax.swing.*;

class MouseFrame extends JFrame {
	public int Frame_HEIGHT = 300;
	public int Frame_WIDTD = 300;
	
	public MouseFrame()
	{
		setTitle("MouseActionTest");
		setSize(Frame_WIDTD,Frame_HEIGHT);
		
		MousePanel panel = new MousePanel();
		Container contentPane = getContentPane();
		contentPane.add(panel);	
		
		
	}
	
}
