
public class ShellSort {
	public static final int N = 30;
	static int seq[] = new int[N];
	
	static{
		for(int i=0;i<seq.length;i++)
		{
			seq[i] = (int) (Math.pow(2,i+1))-1;
		}
	}
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
		hashSort(a);
		System.out.println("这段代码运行了:"+ (System.currentTimeMillis()-t1) + "m秒！");
		System.out.println("=====================");
//		for(int i=0;i<a.length;i++)
//		{
//			System.out.println(a[i]);
//		}
		
	}
	
	public static void hashSort(double []a)
	{
//		for(int i:seq)
//		{
//			System.out.println(i);
//		}
		for(int k=0;k<seq.length;k++)
		{
			for(int i=seq[N-1-k];i<a.length;i+=seq[N-1-k])
			{
				for(int j=i;(j-seq[N-1-k])>=0;j-=seq[N-1-k])
				{
					if(a[j]<a[j-seq[N-1-k]])
					{
						swap(a,j,j-seq[N-1-k]);
					}
				}
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
