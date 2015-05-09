
public class InsertSort {
	public static void main(String[] args) {
		double []a = new double[10];
		for(int i=0;i<a.length;i++)
		{
			a[i] = 100*Math.random();
		}
		for(int i=0;i<a.length;i++)
		{
			System.out.println(a[i]);
		}
		insertSort(a);
		System.out.println("=====================");
		for(double i:a)
		{
			System.out.println(i);
		}
		System.out.println("=====================");
		int []b = new int[2];
		b[0] = 1;
		b[1] = 2;
		swap(b[0],b[1]);
		System.out.println(b[1]);
	}
	
	public static void insertSort(double []a)
	{
		double s;
		for(int i=1;i<a.length;i++)
		{
			for(int j=i;j!=0;j--)
			{
				if(a[j]<a[j-1])
//				swap(a[j],a[j-1]);
				{
					s = a[j];
					a[j] = a[j-1];
					a[j-1] = s;
				}
			}
		}
	}
	public static void swap(double a,double b)
	{
		double c;
		c = a;
		a = b;
		b = c;
		
	}

}
