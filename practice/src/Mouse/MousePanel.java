package Mouse;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.geom.*;
import java.util.ArrayList;

import javax.swing.*;

class MousePanel extends JPanel {
	
	private ArrayList rects;
	private Rectangle2D current;
	private final Double LENGHT = 10.0;
	
	public MousePanel()
	{
		rects = new ArrayList();
		current = null;
		
		addMouseListener(new MouseHandler());
		addMouseMotionListener(new MouseMotionHandler());
	}
	
	public Rectangle2D find(Point2D p)
	{
		for(int i=0;i<rects.size();i++)
		{
			Rectangle2D r =  (Rectangle2D)rects.get(i);
			if(r.contains(p)) return r;
		}
		return null;
	}
	
	public void remove(Rectangle2D s)
	{
		if(s== null) return;
		if(s == current) current = null;
		rects.remove(s);
		repaint();
		
	}
	
	public void add(Point2D p)
	{
		double x = p.getX();
		double y = p.getY();
		
		current = new Rectangle2D.Double(x-LENGHT/2,y-LENGHT/2,LENGHT,LENGHT);
		rects.add(current);
		repaint();
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;
		for(int i=0;i<rects.size();i++)
		{
			g2.draw((Rectangle2D)rects.get(i));
			
		}
	}
	
	private class MouseHandler extends MouseAdapter
	{
	
		public void mousePressed(MouseEvent e)
		{
			current = find(e.getPoint());
			if (current == null) add(e.getPoint());
			
		}
		public void mouseClicked(MouseEvent e)
		{
			current = find(e.getPoint());
			if(current != null && e.getClickCount()>=2)
				remove(current);
		}
	}
	
	
	private class MouseMotionHandler implements MouseMotionListener
	{

		@Override
		public void mouseDragged(MouseEvent e) {
//			// TODO Auto-generated method stub
//			if(find(e.getPoint())==null)
//				setCursor(Cursor.getDefaultCursor());
//			else
//				setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
//			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
//			if(current !=null)
//			{
//				int x = e.getX();
//				int y = e.getY();
//				
//				current.setFrame(x-LENGHT/2,y-LENGHT/2,LENGHT,LENGHT);
//				repaint();
//			}
		}
		
	}

}
