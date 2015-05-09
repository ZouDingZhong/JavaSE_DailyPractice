
public class BubSort {
	public static void main(String[] args) {
		double []a = new double[100000];
		for(int i=0;i<a.length;i++)
		{
			a[i] = 100*Math.random();
		}
//		for(int i=0;i<a.length;i++)
//		{
//			System.out.println(a[i]);
//		}
		long t1=System.currentTimeMillis();
		System.out.println("sort begin");
		bubSort(a);
		System.out.println("这段代码运行了:"+ (System.currentTimeMillis()-t1) + "m秒！");
		System.out.println("=====================");
//		for(int i=0;i<a.length;i++)
//		{
//			System.out.println(a[i]);
//		}
	}
	
	public static void bubSort(double []a)
	{
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a.length-i-1;j++)
			{
				if(a[j]>a[j+1]) swap(a,j,j+1);
			}
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
