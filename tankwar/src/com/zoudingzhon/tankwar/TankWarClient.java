package com.zoudingzhon.tankwar;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

/**
 * 这个类是主框架的类 所有的绘制控制都要通过这个类了进行
 * @author 邹定中
 *
 */
public class TankWarClient extends Frame {

	public static int SIZE_X = 800;
	public static int SIZE_Y = 600;
	
//	各种子弹与爆炸和敌方坦克的容器
	List<Bullet> bullets = new ArrayList<Bullet>();
	private Tank myTank;
    List<Tank> tanks = new LinkedList<Tank>();
    List<Bomb> bombs = new ArrayList<Bomb>();
    Wall wall = new Wall();
    Image offScreenImage = null;
    
//    战场的产生地与构造的地方
	public void frameLaunch()
	{
//		这里是通过配置文件来设置初始坦克数量
	    int initEnemyTankAmount = PropertyMgr.getInitEnemyTankAmount();
		for(int i=0;i<initEnemyTankAmount;i++)
		{
			Tank t =new Tank((int)(770*Math.random()),(int)(30+540*Math.random()),false,this);
			tanks.add(t);
		}
		this.setBackground(Color.GRAY);
		this.setResizable(false);
		this.setTitle("TankWar");
		this.setSize(SIZE_X, SIZE_Y);
		this.setLocation(300, 100);
		this.setVisible(true);
		this.addKeyListener(new KeyMoniter());
		this.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e) {				
			System.exit(0);
			}
		});
		myTank = new Tank(200,200,true,this);		
		new Thread(new PaintThread()).start();
	}
	/**
	 * 绘制的地方
	 * 所有容器类装的东西在绘制后都要判断是否还在生存期 不是的就移除
	 */
	public void paint(Graphics g)
	{
		g.setColor(Color.YELLOW);
		g.drawString("My bullet amount :"+bullets.size(), 30, 50);
		g.drawString("Enemy tanks amount :"+tanks.size(), 30, 70);
		g.drawString("Bombs amount :"+bombs.size(), 30, 90);
		g.drawString("My tank blood left  :"+myTank.blood, 30, 110);
		if(!myTank.getIsLive())
		{
			bombs.add(new Bomb(myTank.getx(),myTank.gety()));
		}
		for(int i=0;i<bombs.size();i++)
		{
			bombs.get(i).draw(g);
			if(!bombs.get(i).getIsLive()) bombs.remove(i);
		}
		
		for(int i=0;i<tanks.size();i++)
		{		
			tanks.get(i).draw(g);
			
//			撞坦克与撞墙处理
			tanks.get(i).crashTanks(tanks);
			tanks.get(i).crashMyTank(myTank);	
			tanks.get(i).crashWall(wall);
			
			if(!tanks.get(i).getIsLive())
				{
					bombs.add(new Bomb(tanks.get(i).getx(),tanks.get(i).gety()));
					tanks.remove(i);
				}
		}
		
		for(int i=0;i<bullets.size();i++)
		{
			bullets.get(i).draw(g);
			bullets.get(i).isLive = bullets.get(i).judgeLive();
			bullets.get(i).isShootWall(wall);
//			遍历所有坦克来判断是否击中坦克
			for(int j=0;j<tanks.size();j++)
			{
				tanks.get(j).judgeLive(bullets.get(i));
				myTank.judgeLive(bullets.get(i));
			}
			if(!bullets.get(i).isLive) 
				{
				bullets.remove(i);
				}
		}
		
		wall.draw(g);
		if(!myTank.getIsLive())
		{
			g.setColor(Color.RED);
			g.setFont(new Font("宋体",Font.BOLD,120));
			g.drawString("GAME OVER", 150, 300);
		}
		myTank.drawLife(g);
		myTank.draw(g);
		myTank.crashWall(wall);
	}
	
//	通过双缓冲来消除闪烁 不得不说效果很好
	public void update(Graphics g) {
		if(offScreenImage == null) {
			offScreenImage = this.createImage(SIZE_X, SIZE_Y);
		}
		Graphics gOffScreen = offScreenImage.getGraphics();
		Color c = gOffScreen.getColor();
		gOffScreen.setColor(Color.GRAY);
		gOffScreen.fillRect(0, 0, SIZE_X, SIZE_Y);
		gOffScreen.setColor(c);
		paint(gOffScreen);
		g.drawImage(offScreenImage, 0, 0, null);
	}

	
	public static void main(String[] args) {
		new TankWarClient().frameLaunch();
	}

//	用来控制重画频率的线程
	public class PaintThread implements Runnable
	{
		@Override
		public void run() {
			while(true)
			{
				try {
					Thread.sleep(50);
					repaint();			
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	private class KeyMoniter extends KeyAdapter
	{
		@Override
		public void keyReleased(KeyEvent e) {
			int key = e.getKeyCode();
			myTank.keyReleased(key);
		}
		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			myTank.setKey(key);
		} 
	}

}
