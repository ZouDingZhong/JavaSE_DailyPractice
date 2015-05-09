
public class MergeSort {
	public static final int N = 10000000;
	
	static double []b;
	public static void main(String[] args) {
		double []a = new double[N];
		b = new double[a.length];
		for(int i=0;i<a.length;i++)
		{
			a[i] = 100*Math.random();
		}
//		for(int i=0;i<a.length;i++)
//		{
//			System.out.println(a[i]);
//		}
		long t1=System.currentTimeMillis();
		mergeSort(a,0,(0+a.length-1)/2,a.length-1);
		System.out.println("这段代码运行了:"+ (System.currentTimeMillis()-t1) + "m秒！");
		System.out.println("=====================");
//		for(int i=0;i<a.length;i++)
//		{
//			System.out.println(a[i]);
//		}
	}
	
	public static void mergeSort(double []a,int f,int m,int e)
	{
		if(f>=e) return;
		mergeSort(a,f,(f+m)/2,m);
		mergeSort(a,m+1,(m+1+e)/2,e);
		merge(a,f,(f+e)/2,e);
	}
	public static void merge(double []a,int f,int m,int e)
	{
		int l = f,r = m+1;
		for(int k=l;k<=r;k++)
		{
			b[k] = a[k];
		}
		for(int nb=f;nb<=e;nb++)
		{
			if(l>m)       a[nb] = b[r++];
			else if(r>e)       a[nb] = b[l++];
			else if(a[l]>a[r]) a[nb] = b[r++]; 
			else if(a[l]<a[r]) a[nb] = b[l++]; 
		}
	}
	public static void swap(double[]a,int b,int c)
	{
		double s;
		s = a[b];
		a[b] = a[c];
		a[c] = s;
		
	}

}
