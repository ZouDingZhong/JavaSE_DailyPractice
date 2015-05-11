package Chapter_8;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;;

class MyPanel extends JPanel {
	public MyPanel()
	{
		JButton bButton = new JButton("blue");
		JButton rButton = new JButton("red");
		
		add(bButton);
		add(rButton);
		
		ActionListener bButtonAction = new ColorAction(Color.BLUE);
		ActionListener rButtonAction = new ColorAction(Color.RED);
		
		bButton.addActionListener(bButtonAction);
		rButton.addActionListener(rButtonAction);
	}
	private class ColorAction implements ActionListener
	{

		private Color c;
		public ColorAction(Color color)
		{
			c = color;
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			setBackground(c); 
		}
		
	}
}
