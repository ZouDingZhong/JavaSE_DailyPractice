
public class QuickSort {
	public static void main(String[] args) {
		double []a = new double[10];
//		for(int i=0;i<a.length;i++)
//		{
//			a[i] = 100*Math.random();
//		}
//		double []a = {5,1,2,3,4};
//		for(int i=0;i<a.length;i++)
//		{
//			System.out.println(a[i]);
//		}
//		long t1=System.currentTimeMillis();
//		quickSort(a,0,a.length-1);
//		System.out.println("这段代码运行了:"+ (System.currentTimeMillis()-t1) + "m秒！");
		System.out.println("=====================");
//		for(int i=0;i<a.length;i++)
//		{
//			System.out.println(a[i]);
//		}
	}
	
	public static void quickSort(double []a,int f,int e)
	{
		int sure;
		if(f>=e)return;
		sure = exchange(a,f,e);
		quickSort(a,f,sure-1);
		quickSort(a,sure+1,e);
	}
	public static int exchange(double[]a,int f,int e)
	{
		double mainNum = a[f];
		int l = f+1;
		int r = e;
		while(true)
		{
			while(a[l]<mainNum)
			{
				l++;
				if(l==e)break;
			}
			while(a[r]>mainNum)
			{
				r--;
				if(r==f)break;
			}
			if(l>=r)break;
			swap(a,l,r);
		}
		swap(a,r,f);
		return r;
	}
	public static void swap(double[]a,int b,int c)
	{
		double s;
		s = a[b];
		a[b] = a[c];
		a[c] = s;
		
	}


}
