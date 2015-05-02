package com.zoudingzhon.tankwar;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;
/**
 * 这个类是用来描述坦克的
 * @author 邹定中
 *
 */
public class Tank {
	
	enum Direction {L, LU, U, RU, R, RD, D, LD, STOP};
	private boolean  bL=false, bU=false, bR=false, bD = false;

	private int XSPEED = 10;
	private int YSPEED = 10;
	private int t_x = 200;
	private int t_y = 200;
	private boolean isGood = false;
	private Direction dir = Direction.STOP; 
	private Direction ptDir = Direction.L;
	private TankWarClient tc = null;
	private boolean isLive = true;
	private int step=r.nextInt(10)+10;
    private int OldX=0;
    private int OldY=0;
    int blood =100;
        
    public void setIsLive(boolean b)
    {
    	isLive = b;
    }
    
	private static Random r = new Random();
	
	public Tank(int t_x, int t_y,boolean b) {
		this.t_x = t_x;
		this.t_y = t_y;
		isGood = b;
	}
	
	public Tank(int x,int y,boolean b,TankWarClient tc)
	{
		this(x,y,b);
		this.tc = tc;
	}
	
	public void draw(Graphics g)
	{
		if(!isLive) return;
		Color c = g.getColor();
		if(isGood)
		{
			g.setColor(Color.RED);
		}
		else
		{
			g.setColor(Color.BLUE);
		}
		g.fillOval(t_x, t_y, 30, 30);
		g.setColor(c);
		drawPt(g);		
		move();
	}
	
	/**
	 * 用来画炮筒的
	 * @param g
	 */
	public void drawPt(Graphics g)
	{
		if(isGood)g.setColor(Color.YELLOW);
		else g.setColor(Color.BLACK);
		switch(ptDir) {
		case L:
			g.drawLine(t_x+15, t_y+15, t_x, t_y+15);
			break;
		case LU:
			g.drawLine(t_x+15, t_y+15, t_x, t_y);
			break;
		case U:
			g.drawLine(t_x+15, t_y+15, t_x+15, t_y);
			break;
		case RU:
			g.drawLine(t_x+15, t_y+15, t_x+30, t_y);
			break;
		case R:
			g.drawLine(t_x+15, t_y+15, t_x+30, t_y+15);
			break;
		case RD:
			g.drawLine(t_x+15, t_y+15, t_x+30, t_y+30);
			break;
		case D:
			g.drawLine(t_x+15, t_y+15, t_x+15, t_y+30);
			break;
		case LD:
			g.drawLine(t_x+15, t_y+15, t_x, t_y+30);
			break;
		case STOP:
			break;
		}
	}
	
	/**
	 * 用来发射子弹
	 * @return 返回产生的子弹
	 */
	public Bullet fire()
	{
		return new Bullet(t_x+15,t_y+15,isGood,ptDir);	
	}
	
	public Rectangle getRect()
	{
		return(new Rectangle(t_x,t_y,30,30));
	}
	public boolean getIsLive()
	{
		return isLive;
	}
	
	public void judgeLive(Bullet b)
	{
//		判断是否与异种属性的子弹相交
		if(getRect().intersects(b.getRect())&&isGood!=b.getIsGood()) 
		{
			if(isLive)
			{
			b.setIsLive(false);
			}
//			用来扣除自己坦克的血量
			if(isGood)
			{
//????????为什么被调用了5次？ 不明白
				blood =blood - 4;
				if(blood<=0) 
				isLive = false;
			}
			else
			isLive = false;
					
		}
	}
	
	public int getx()
	{
		return t_x;
	}
	public int gety()
	{
		return t_y;
	}		
	
	/**
	 * 用来处理与我方坦克相撞
	 * @param t我方坦克
	 */
	public void crashMyTank(Tank t)
	{
		if(this.getRect().intersects(t.getRect()))
		{
			dir = Direction.STOP;
			t_x=OldX;
			t_y=OldY;
			t.dir =Direction.STOP;
			t.t_x=t.OldX;
			t.t_y=t.OldY;
		}
	}
	/**
	 * 用来处理与敌方坦克相交
	 * @param list用来盛放敌方坦克的容器
	 */
	public void crashTanks(List<Tank> list)
	{
		for(int i=0;i<list.size();i++)
		{
			if(!this.equals(list.get(i)))
			{
				if(this.getRect().intersects(list.get(i).getRect()))
				{

					dir = Direction.STOP;
					t_x=OldX;
					t_y=OldY;
					list.get(i).dir = Direction.STOP;
					list.get(i).t_x=list.get(i).OldX;
					list.get(i).t_y=list.get(i).OldY;
				}
			}
		}
	}
	
	public void setKey(int k)
	{
		switch(k) {
	   case KeyEvent.VK_A : 
		   for(int i=0;i<3;i++)
		   {			   
			   Tank t =new Tank((int)(770*Math.random()),(int)(30+540*Math.random()),false,tc);
			   tc.tanks.add(t);
		   }
		   break;
		case KeyEvent.VK_F2 :
			if(!isLive){isLive = true; blood = 100; }
			break;
		case KeyEvent.VK_LEFT :
			bL=true;
			break;
		case KeyEvent.VK_UP :
			bU=true;
			break;
		case KeyEvent.VK_RIGHT :
			bR=true;
			break;
		case KeyEvent.VK_DOWN :
			bD=true;
			break;
		}
		changeDir();
	}
	
	public void changeDir()
	{
		if(bL && !bU && !bR && !bD) dir = Direction.L;
		else if(bL && bU && !bR && !bD) dir = Direction.LU;
		else if(!bL && bU && !bR && !bD) dir = Direction.U;
		else if(!bL && bU && bR && !bD) dir = Direction.RU;
		else if(!bL && !bU && bR && !bD) dir = Direction.R;
		else if(!bL && !bU && bR && bD) dir = Direction.RD;
		else if(!bL && !bU && !bR && bD) dir = Direction.D;
		else if(bL && !bU && !bR && bD) dir = Direction.LD;
		else if(!bL && !bU && !bR && !bD) dir = Direction.STOP;
		if(dir!=Direction.STOP){ptDir = dir;}
	}
	
	public void move()
	{
		OldX = t_x;
		OldY = t_y;
			
		switch(dir) {
		case L:
			t_x -= XSPEED;
			break;
		case LU:
			t_x -= XSPEED;
			t_y -= YSPEED;
			break;
		case U:
			t_y -= YSPEED;
			break;
		case RU:
			t_x += XSPEED;
			t_y -= YSPEED;
			break;
		case R:
			t_x += XSPEED;
			break;
		case RD:
			t_x += XSPEED;
			t_y += YSPEED;
			break;
		case D:
			t_y += YSPEED;
			break;
		case LD:
			t_x -= XSPEED;
			t_y += YSPEED;
			break;
		case STOP:
			break;
		}
//		用来处理坦克撞墙
		if(t_x<0)t_x=0;
		if(t_y<20)t_y=20;
		if(t_x>800-30)t_x=800-30;
		if(t_y>600-30)t_y=600-30;
		
//		用来使敌方坦克往随机方向移动 step是表示多少步后转向
		if(!isGood)
		{
			if(step == 0)
			{	
				Direction[] d = Direction.values();
				dir = d[r.nextInt(d.length)];
				step = r.nextInt(10)+10;
				if(dir!=Direction.STOP){ptDir = dir;}
			}
			step--;
		
			if(r.nextInt(50)>45&&tc!=null)
			tc.bullets.add(fire());
			
		}
	}

	public void keyReleased(int k) {
		switch(k) {
		case KeyEvent.VK_SPACE :
			if(isLive)
			tc.bullets.add(fire());
			break;
		case KeyEvent.VK_LEFT :
			bL=false;
			break;
		case KeyEvent.VK_UP :
			bU=false;
			break;
		case KeyEvent.VK_RIGHT :
			bR=false;
			break;
		case KeyEvent.VK_DOWN :
			bD=false;
			break;
		}
		changeDir();
		
	}
	
//	用来处理与障碍物相撞
	public boolean crashWall(Wall w)
	{
		if(getRect().intersects(w.getRect())) 
		{
			dir = Direction.STOP;
			t_x=OldX;
			t_y=OldY;
			return true;
		}
		return false;
	}
	
	/**
	 * 画出我方坦克的血条
	 * @param g
	 */
	public void drawLife(Graphics g)
	{
		g.setColor(Color.RED);
		g.drawRect(t_x-5, t_y-20, 40, 10);
		g.fillRect(t_x-5, t_y-20, 40*blood/100, 10);
	}
}
