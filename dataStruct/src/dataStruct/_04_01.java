package dataStruct;

import java.util.Scanner;

public class _04_01 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N = Integer.parseInt(input.nextLine());
		int n;
		int[] points = new int[100];
		for(int i=0;i<N;i++)
		{
			n = input.nextInt();
			insert(points,n,0);
		}
		for(int i=0;i<N;i++)
		{
			System.out.print(points[i]+"   ");
		}
//		System.out.println(points[0]);
	}
	public static void insert(int[] points,int n,int index)
	{
		if(points[0]==0)
		{
			points[0]=n;
		}
		if(points[index*2+1]==0&&n<points[index])
		{
			points[index*2+1] = n;
		}
		else if(points[index*2+2]==0&&n>points[index])
		{
			points[index*2+2] = n;
		}
		else if(points[index*2+1]!=0&&n<points[index])
		{
			insert(points,n,index*2+1);
		}
		else if(points[index*2+2]!=0&&n>points[index])
		{
			insert(points,n,index*2+2);
		}
//		else
//		{
//			System.out.println("ÊäÈë´íÎó£¡");
//		}
	}
}
