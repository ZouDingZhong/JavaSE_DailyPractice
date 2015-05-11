package KeyAction;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import javax.swing.*;;

class KeyTestPanel extends JPanel {
	
	private ArrayList lines;
	private Point2D lastPoint;
	
	public KeyTestPanel()
	{
		lines = new ArrayList() ;
		lastPoint = new Point2D.Double(50,50);
		
		KeyHandler listener = new KeyHandler();
		addKeyListener(listener);
		setFocusable(true);
	}
	
	public void add(double dx,double dy)
	{
		Point2D endPoint = new Point2D.Double(lastPoint.getX()+dx,
                lastPoint.getY()+dy);
		lines.add(new Line2D.Double(lastPoint,endPoint));
		lastPoint = endPoint;
		repaint();
		
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;
		for(int i=0;i<lines.size();i++)
		{
			g2.draw((Line2D)lines.get(i));
		}
		
	}
	
	private final int SMOVEDISTANCE = 10; 
	private final int LMOVEDISTANCE = 20;
	
	private class KeyHandler implements KeyListener
	{

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			int keyCode = e.getKeyCode();
			int d;
			if(e.isShiftDown())
			{
				d = LMOVEDISTANCE;
			}
			else
			{
				d = SMOVEDISTANCE;
			}
			if(keyCode == KeyEvent.VK_LEFT) add(-d,0);
			else if (keyCode == KeyEvent.VK_RIGHT) add(d,0);
			else if (keyCode == KeyEvent.VK_UP) add(0,-d);
			else if (keyCode == KeyEvent.VK_DOWN) add(0,d);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}

}
