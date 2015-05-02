package com.zou.snake;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Yard extends Frame{

	public static final int ROWS = 30;
	public static final int COLS = 30;
	public static final int BLOCK_SIZE = 15;
	
	public boolean gameOver = false;
	
	private Egg e = new Egg();
	private Snake s = new Snake(this);
	PaintThread paintThread = new PaintThread();
		
	public void launch() {
		this.setLocation(200, 200);
		this.setSize(COLS * BLOCK_SIZE, ROWS * BLOCK_SIZE);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		this.setVisible(true);
		
		this.addKeyListener(new KeyMonitor());
		
		new Thread(paintThread).start();
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Yard y = new Yard();
		y.launch();		
		
	}
	{
	this.setTitle("Ã∞≥‘…ﬂ");
	}
	public void paint(Graphics g)
	{
		Color c = g.getColor();
		g.setColor(Color.GRAY);
//		for(int i=0;i<ROWS;i++)
//		{
//			g.drawLine(0, i*BLOCK_SIZE,COLS*BLOCK_SIZE ,i*BLOCK_SIZE);
//		}
//		for(int i=1; i<COLS; i++) {
//			g.drawLine(BLOCK_SIZE * i, 0, BLOCK_SIZE * i, BLOCK_SIZE * ROWS);
//
//		}
		if(gameOver)
		{
			g.setColor(Color.YELLOW);
			g.setFont(new Font("ÀŒÃÂ",Font.BOLD,50));
		   g.drawString("GAME OVER",100, 200);
		}
		g.setColor(c);
		s.eat(e);
		s.draw(g);
		e.draw(g);
	}
	
	private class KeyMonitor extends KeyAdapter {
//
//		@Override
		public void keyPressed(KeyEvent e) {
//			int key = e.getKeyCode();
//			if(key == KeyEvent.VK_F2) {
//				paintThread.reStart();
//			}
			s.keyPressed(e);
		}
//		
	}
	  public void stop()
	  {
		  paintThread.gameOver();
	  }


	private class PaintThread implements Runnable 
	{
	    boolean running = true;
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(running)
			{
			s.move();
            repaint();
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}
	   public void gameOver()
	   {
		   running = false;
		   gameOver = true;
	   }

	}
	

	

}
