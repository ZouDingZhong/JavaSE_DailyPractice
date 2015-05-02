package com.zoudingzhon.tankwar;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * 这个类是描述子弹的
 * @author 邹定中
 *
 */
public class Bullet {
	
	public static final int SPEED = 20;
	
	private int x;
	private int y;
    boolean isLive = true;
	private Tank.Direction dir;
	private TankWarClient tc;
	private boolean isGood = true;
	public Bullet(int x, int y, boolean b, Tank.Direction dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		isGood = b;
	}
	public Bullet(int x, int y,boolean b, Tank.Direction dir,TankWarClient tc)
	{
		this(x,y,b,dir);
		this.tc = tc;
	}
	
	public void isShootWall(Wall w)
	{
		if(getRect().intersects(w.getRect())) isLive = false;
	}
	
	public void draw(Graphics g)
	{
		move();
		Color c = g.getColor();
		if(isGood)  g.setColor(Color.YELLOW.brighter().brighter().brighter());
		if(!isGood)  g.setColor(Color.BLACK);
		if(isLive)
		g.fillOval(x-5, y-5, 10, 10);
		g.setColor(c);		
	}
	
	public boolean getIsGood()
	{
		return isGood;
	}
	
	public Rectangle getRect()
	{
		return(new Rectangle(x,y,10,10));
	}
	
	public void setIsLive(boolean b)
	{
		isLive = b;
	}
	
	/**
	 * 这个方法是用来判断是否撞墙的
	 * @return 撞上了返回false 否则返回true
	 */
	public boolean judgeLive()
	{
		if(x<0||y<0||x>TankWarClient.SIZE_X||y>TankWarClient.SIZE_Y) return false;
		
		return true;
	}
	
	public void move()
	{
		switch(dir) {
		case L:
			x -= SPEED;
			break;
		case LU:
			x -= SPEED;
			y -= SPEED;
			break;
		case U:
			y -= SPEED;
			break;
		case RU:
			x += SPEED;
			y -= SPEED;
			break;
		case R:
			x += SPEED;
			break;
		case RD:
			x += SPEED;
			y += SPEED;
			break;
		case D:
			y += SPEED;
			break;
		case LD:
			x -= SPEED;
			y += SPEED;
			break;
		}
	}
	public int getx()
	{
		return x;
	}
	public int gety()
	{
		return y;
	}
	
}
