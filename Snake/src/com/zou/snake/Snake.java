package com.zou.snake;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
public class Snake {
	public static final int ROWS = 30;
	public static final int COLS = 30;
	public static final int BLOCK_SIZE = 15;
    private Yard y;
	
	private Node head;
	private Node tail;
	
	private Node n = new Node(15,15,Dir.L);
	private Node l = new Node(16,15,Dir.L);
	
	public Snake(Yard y)
	{
		head = n;
		n.next=l;
		l.prev=n;
		tail = l;
		this.y = y;
	}
	
	public boolean isDead()
	{
	    if(head.col<0||head.row<2||head.col>Yard.COLS||head.row>Yard.ROWS) return false;
	    for(Node n=head.next;n!=null;n=n.next)
	    {
	    	if(head.equals(n))
	    	return false;
	    }
		return true;
	}
	
	public void eat(Egg e) {
		if(this.getRect().intersects(e.getRect())) {
			e.reAppear();
			this.addToHead();
//			y.setScore(y.getScore() + 5);
		}
	}

	private Rectangle getRect() {
		return new Rectangle(Yard.BLOCK_SIZE * head.col, Yard.BLOCK_SIZE * head.row, head.w, head.h);
	}
	
	public void move()
	{
		addToHead();
		tail.prev.next=null;
		tail = tail.prev;
		if(!isDead()) 
		{
			y.stop();
		}
	}
	
	public void addToHead()	
	{
		Node node = null;
	    switch(head.dir) 
	    {
	    case L :
			node = new Node(head.row, head.col - 1, head.dir);
			break;
		case U :
			node = new Node(head.row - 1, head.col, head.dir);
			break;
		case R :
			node = new Node(head.row, head.col + 1, head.dir);
			break;
		case D :
			node = new Node(head.row + 1, head.col, head.dir);
			break;
		}
	    head.prev = node;
	    node.next = head;
	    head = node;
	}
	
	public void addToTail()
	{
		Node node = null;
	    switch(tail.dir) 
	    {
	    case L :
		 node = new Node(tail.row, tail.col + 1, tail.dir);
		 break;
     	case U :
		 node = new Node(tail.row + 1, tail.col, tail.dir);
		 break;
    	case R :
		 node = new Node(tail.row, tail.col - 1, tail.dir);
		 break;
    	case D :
		 node = new Node(tail.row - 1, tail.col, tail.dir);
		 break;
	    }
	    tail.next = node;
	    node.prev = tail;
	    tail = node;
		}
	
	public void changeDir(Dir dir)
	{
		head.dir = dir;
	}
	
	public void draw(Graphics g)
	{
		Node n ;
		for(n=head;n!=null;n=n.next)
		{
			n.paint(g);
		}
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		switch(key) {
		case KeyEvent.VK_LEFT :
			if(head.dir != Dir.R)
				head.dir = Dir.L;
			break;
		case KeyEvent.VK_UP :
			if(head.dir != Dir.D)
				head.dir = Dir.U;
			break;
		case KeyEvent.VK_RIGHT :
			if(head.dir != Dir.L)
				head.dir = Dir.R;
			break;
		case KeyEvent.VK_DOWN :
			if(head.dir != Dir.U)
				head.dir = Dir.D;
			break;
		}
	}
	
	
private	class Node
	{
		int w = Yard.BLOCK_SIZE;
		int h = Yard.BLOCK_SIZE;
		int row ;
		int col ;
		Dir dir;
		Node next = null;
		Node prev = null;
		
		
		Node(int row, int col, Dir dir) {
			this.row = row;
			this.col = col;
			this.dir = dir;
		}
		
        public void paint(Graphics g)
        {
//        	Color c = g.getColor();
			g.setColor(Color.BLACK);
			g.fillRect(Yard.BLOCK_SIZE * col, Yard.BLOCK_SIZE * row, w, h);
//			g.setColo.r(c);        	
        }
		
		public boolean equals(Node n)
		{
			return(this.col==n.col&&this.row==n.row);
		}
	}


}



