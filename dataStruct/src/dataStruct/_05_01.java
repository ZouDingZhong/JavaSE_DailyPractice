package dataStruct;

import java.util.LinkedList;
import java.util.Scanner;

public class _05_01 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N,E;
		int l,r;
//		String[] strs = new String[2];
		String[] strs = input.nextLine().split(" ");
		N = Integer.parseInt(strs[0]);
		E = Integer.parseInt(strs[1]);
//		N = input.nextInt();
//		E = input.nextInt();
//		input.nextLine();
		Point[][] points = new Point[N][N];
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				points[i][j] = new Point();
			}
		}
		for(int i=0;i<E;i++)
		{
			strs = input.nextLine().split(" ");
//			System.out.println(strs[0]+"!!!"+strs[1]);
			l = Integer.parseInt(strs[0]);
			r = Integer.parseInt(strs[1]);
//			System.out.println(l+"   "+r);
			points[l][r].setLink(true);;
		}
//		printGraph(N,points);
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				if(i==j)
				{
					points[i][j].setLink(true);
					points[i][j].setValue(i);
				}
				if(points[i][j].isLink())
				{
					points[j][i].setLink(true);
				}
			}
		}
//		printGraph(N,points);
//		System.out.println("isWork?");
		DFS(points);
		refresh(points);
		BFS(points);
	}
	private static void refresh(Point[][] points) {
		for(int i=0;i<points.length;i++)
		{
			for(int j=0;j<points[i].length;j++)
			{
				points[i][j].setRead(false);
			}
		}
	}
	public static void BFS(Point[][] points)
	{
		for(int i=0;i<points.length;i++)
		{
			if(!points[i][i].isRead())
			{
				System.out.print("{ ");
				BFS(points,i);
				System.out.print("}");
				System.out.println();
			}
		}
	}
	public static void BFS(Point[][] points,int tline)
	{
		LinkedList<Point> queue = new LinkedList();
		int line = tline;
		if(!points[line][line].isRead())
		{
			queue.add(points[line][line]);
			points[line][line].setRead(true);
		}
		while(!queue.isEmpty())
		{
			line = queue.getFirst().getValue();
//			points[line][line].setRead(true);
			System.out.print(line+" ");
			queue.removeFirst();
			
			for(int i=0;i<points.length;i++)
			{
				if(points[line][i].isLink()&&(!points[i][i].isRead()))
				{
					points[i][i].setRead(true);
					queue.add(points[i][i]);
				}
			}
		}
	}
	public static void DFS(Point[][] points)
	{
		int N = points[0].length;
		for(int i=0;i<N;i++)
		{
			if(!points[i][i].isRead())
			{
				System.out.print("{ ");
				DFS(points,i);
				System.out.print("}");
				System.out.println();
			}
			
		}
	}
	public static void DFS(Point[][] points,int line)
	{
		boolean b = true;
		for(int i=0;i<points[line].length;i++)
		{
//System.out.println("isWork?");
			if(points[line][i].isLink()&&(!points[line][i].isRead()))
			{
				b = false;
				if(!points[i][i].isRead())
				System.out.print(i+" ");
				points[line][i].setRead(true);
				points[i][line].setRead(true);
				points[i][i].setRead(true);
				if(i!=line)
				{
					DFS(points,i);
				}
			}
		}
//		if(b)return;
	}
	
	public static void printGraph(int N,Point[][] points)
	{
		for(int i=0;i<N;i++)
		{
			if(i==0)
			{
				System.out.print("        ");
			}
			System.out.printf("%8d",i);
		}
		System.out.println();
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				if(j == 0)
				{
					System.out.printf("%8d",i);
				}
				System.out.printf("%8s",points[i][j].isLink());
			}
			System.out.println();
		}

	}

}
class Point
{
	private boolean isLink = false;
	private boolean isRead = false;
	private int value = -1;
//	public Point()
//	{
//		isLink = false;
//	}
	
	public boolean isRead() {
		return isRead;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}
	public boolean isLink() {
		return isLink;
	}
	public void setLink(boolean isLink) {
		this.isLink = isLink;
	}
	
	
}
