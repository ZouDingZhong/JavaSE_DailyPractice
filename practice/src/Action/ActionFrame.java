package Action;

import java.awt.Container;

import javax.swing.*;


class ActionFrame extends JFrame {

	public int Frame_HEIGHT = 300;
	public int Frame_WIDTD = 300;
	
	public ActionFrame()
	{
		setTitle("ActionTest");
		setSize(Frame_WIDTD,Frame_HEIGHT);
		
		ActionPanel panel = new ActionPanel();
		Container contentPane = getContentPane();
		contentPane.add(panel);	
		
		
	}
}
