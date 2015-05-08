package dataStruct;

import java.util.Scanner;

public class _03_01 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double[] a = new double[4];
		double left;
		double right;
		for(int i=0;i<4;i++)
		{
			a[3-i] = input.nextDouble();
		}
		left = input.nextDouble();
		right = input.nextDouble();
		
		System.out.printf("%.2f",(double)(Math.round(100*run(a,left,right)))/100);
		
	}
	
	public static double run(double[]a,double l,double r)
	{
		if((r-l)<0.001)
		{
			return (l+r)/2;
		}
		double rl = calculate(a,l);
		double rr = calculate(a,r);
		double mid = (l+r)/2;
		double rmid = calculate(a,mid);
		if(rl*rr>0)
		{
			return 1111;
		}
		else if(rl*rr<0)
		{
			if(rmid == 0) return mid;
			if(rmid*rl>0) return run(a,mid,r);
			else		  return run(a,l,mid);
		}
		return 9999;
	}
	public static double calculate(double[]a,double d)
	{
		double result;
		result = a[3]*Math.pow(d, 3)+a[2]*Math.pow(d, 2)+a[1]*Math.pow(d, 1)+a[0];
		return result;
	}

}
