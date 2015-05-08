package dataStruct;

import java.util.Scanner;

public class _01_01 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int k = input.nextInt();
		int []a = new int[k];
		int max=0;
		int add=0;
		
		for(int i=0;i<k;i++)
		{
			a[i] = input.nextInt(); 
			add += a[i];
			if(add>max)
			{
				max = add;
			}
			if(add < 0)
			{
				add = 0;
			}
		}
		System.out.println(max);

	}

}
