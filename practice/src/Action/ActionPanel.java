package Action;

import java.awt.Color;
import java.awt.Panel;
import java.awt.event.ActionEvent;

import javax.swing.*;

class ActionPanel extends JPanel {
	public ActionPanel()
	{
		setBackground(Color.BLACK);
		ColorAction blueAction = new ColorAction("Blue",Color.BLUE);
		ColorAction redAction = new ColorAction("Red",Color.RED);
		
		add(new JButton(blueAction));
		add(new JButton(redAction));
		
		InputMap imap = getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
		imap.put(KeyStroke.getKeyStroke("ctrl B"),"panel.Blue");
		imap.put(KeyStroke.getKeyStroke("ctrl R"),"panel.Red");
		
		ActionMap amap = getActionMap();
		amap.put("panel.Blue", blueAction);
		amap.put("panel.Red", redAction);
	}

	private class ColorAction extends AbstractAction
	{
//		private String name;
//		private Color color;

		public ColorAction(String name,Color color)
		{
			putValue(Action.NAME,name);
			putValue("color",color);
			putValue(Action.SHORT_DESCRIPTION,"Set panel color to "+name.toLowerCase());
			
//			this.name = name;
//			this.color = color;
			
		}
		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			Color c = (Color)getValue("color");
			setBackground(c);
		}
		
	}
}
