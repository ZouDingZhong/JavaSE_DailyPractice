package Chapter_7;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

class Mypanel extends JPanel {

	public void paintComponent(Graphics g)
	{
	     double POINT_X =100;
	     double POINT_Y =100;
	     double LENGT = 100;
	     double HIGHT = 100;   
	     String filename = "C:\\Users\\USER\\Desktop\\test.jpg";
	     Image image = null;
	     
		try {
			image = ImageIO.read(new File(filename));
		} catch (IOException e) {
			// TODO Auto-generated catch block
              System.out.println("import image failure");
		}
		
	     g.drawImage(image, 0,0, null);
	     
	     Graphics2D g2 = (Graphics2D)g;
	     g2.setPaint(Color.RED);
	     Rectangle2D rect = new Rectangle2D.Double(POINT_X,POINT_Y,LENGT,HIGHT);
         g2.fill(rect);
	     g2.draw(rect);
	     Point2D point = new Point2D.Double(POINT_X-10,POINT_Y-10);
//	     g2.draw((Shape) point);
	     g2.setPaint(Color.BLACK);
	     double radius =10;
	     Ellipse2D circle = new Ellipse2D.Double();
	     circle.setFrameFromCenter(rect.getCenterX(),rect.getCenterY(),
	         rect.getCenterX()+radius,rect.getCenterY()+radius);
	     g2.fill(circle);
	     g2.draw(circle);
	
	     
         
         
         
	}
	public static int MESSAGE_X =100;
	public static int MESSAGE_Y =100;
}
