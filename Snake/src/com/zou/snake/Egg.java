package com.zou.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Egg {
    int row,col;
	int w = Yard.BLOCK_SIZE;
	int h = Yard.BLOCK_SIZE;
	private static Random r = new Random();
	public Egg()
	{
		row = r.nextInt(Yard.ROWS-2)+2;
		col = r.nextInt(Yard.COLS);
	}
	public Rectangle getRect() {
		return new Rectangle(Yard.BLOCK_SIZE * col, Yard.BLOCK_SIZE * row, w, h);
	}
	public void reAppear()
	{
		row = r.nextInt(Yard.ROWS-2)+2;
		col = r.nextInt(Yard.COLS);
	}

	public void draw(Graphics g)
	{
		g.setColor(Color.GREEN);
		g.fillOval(Yard.BLOCK_SIZE * col, Yard.BLOCK_SIZE * row, Yard.BLOCK_SIZE, Yard.BLOCK_SIZE);
	}
}
