package dataStruct;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class _05_02 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N,D;
		int x,y;
		List<Dot> firstDots = new ArrayList<Dot>();
		String[] strs = input.nextLine().split(" ");
		N = Integer.parseInt(strs[0]);
		D = Integer.parseInt(strs[1]);
		Dot[] dots = new Dot[N];
		for(int i=0;i<N;i++)
		{
			strs = input.nextLine().split(" ");
			x = Integer.parseInt(strs[0]);
			y = Integer.parseInt(strs[1]);
			dots[i] = new Dot(x,y);
		}
//		for(int i=0;i<dots.length;i++)
//		{
//			System.out.println(dots[i].getX()+"   "+dots[i].getY());
//		}
		getFirstDots(firstDots,dots,D);
		if(firstDots.isEmpty())
		{
			System.out.println("No");
			System.exit(0);
		}
//		Iterator it = firstDots.iterator();
//		Dot pdot = new Dot(0,40);
//		Dot tdot = new Dot(0,21);
//		System.out.println(isCan(D,pdot,tdot));
//		System.out.println(isCanOut(D,pdot));
//		while(it.hasNext())
//		{
//			pdot = (Dot)it.next();
//			System.out.println(pdot.getX()+"  "+pdot.getY());
//		}
		Iterator it = firstDots.iterator();
		Dot pdot = new Dot(0,40);
		while(it.hasNext())
		{
			pdot = (Dot)it.next();
//			System.out.println(pdot.getX()+"  "+pdot.getY());
			DFS(dots,pdot,D);
		}
		System.out.println("No");
//		DFS(dots,,D);
	}
	public static void getFirstDots(List firstDots,Dot[] dots,int D)
	{
		for(int i=0;i<dots.length;i++)
		{
			if(Math.pow((D+15/2),2)>(Math.pow(dots[i].getX(),2)+Math.pow(dots[i].getY(),2)))
			{
				firstDots.add(dots[i]);
			}
		}
	}
	public static void DFS(Dot[] dots,Dot dot,int D)
	{
		for(int i=0;i<dots.length;i++)
		{
			if((!dots[i].isVisited())&&isCan(D,dot,dots[i]))
			{
				if(isCanOut(D,dots[i]))
				{
					System.out.println("Yes");
					System.exit(0);
				}
				dots[i].setVisited(true);
				DFS(dots,dots[i],D);
			}
		}
	}
	public static boolean isCanOut(int D,Dot dot)
	{
		if((D>(50-Math.abs(dot.getX())))||(D>(50-Math.abs(dot.getY()))))
		{
			return true;
		}
		return false;
	}
	public static boolean isCan(int D,Dot origin,Dot purpose)
	{
		if(D*D>(Math.pow((origin.getX()-purpose.getX()),2)+Math.pow((origin.getY()-purpose.getY()),2)))
		{
			return true;
		}
		return false;
	}
	
}
class Dot
{
	private int X;
	private int Y;
	private boolean isVisited = false;
	
	public boolean isVisited() {
		return isVisited;
	}
	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}
	public Dot(int x, int y) {
		X = x;
		Y = y;
	}
	public int getX() {
		return X;
	}
	public void setX(int x) {
		X = x;
	}
	public int getY() {
		return Y;
	}
	public void setY(int y) {
		Y = y;
	}
	
}
