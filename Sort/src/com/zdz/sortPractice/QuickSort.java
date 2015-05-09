package com.zdz.sortPractice;

public class QuickSort {

	public static void main(String[] args) {
		int []a = new int[10];
		for(int i=0;i<a.length;i++)
		{
			a[i] = (int) (100*Math.random());
		}
		for(int i=0;i<a.length;i++)
		{
			System.out.println(a[i]);
		}
//		long t1=System.currentTimeMillis();
		quickSort(a);
//		System.out.println("这段代码运行了:"+ (System.currentTimeMillis()-t1) + "m秒！");
		System.out.println("=====================");
		for(int i=0;i<a.length;i++)
		{
			System.out.println(a[i]);
		}
	}
	public static void quickSort(int[] a)
	{
		if(a==null) return;
		_quickSort(a,0,a.length-1);
	}
	private static void _quickSort(int[] a, int start, int end) {
		if(a==null) return;
		int main = start;
		int l = start + 1;
		int r = end;
		if(start >= r)return;
		while(true)
		{
			while(a[l]<a[main]) 
			{
				l++;
				if(l==end) break;
			}
			while(a[r]>a[main]) 
			{
				r--;
				if(r==start)break;
			}
			if(l>=r)break;
			swap(a,l,r);
		}
		swap(a,r,main);
		_quickSort(a,start,l-1);
		_quickSort(a,l+1,end);		
	}
	public static void swap(int[] str,int start,int i)
	{
		if(i==start)return;
		int swap;
		swap = str[start];
		str[start] = str[i];
		str[i] = swap;
	}
}
