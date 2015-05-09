
public class SelectSort {
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
		selectSort(a);
		System.out.println("=====================");
		for(int i=0;i<a.length;i++)
		{
			System.out.println(a[i]);
		}
	}
	
	public static void selectSort(double []a)
	{
		double min;
		int flag;
		for(int i=0;i<a.length;i++)
		{
			min = a[i];
			flag = i;
			for(int j=i;j<a.length;j++)
			{
				if(min>a[j])
				{
					min = a[j];
					flag = j;
				}
			}
			if(flag!=i)
			{
//				s = a[i];
//				a[i] = a[flag];
//				a[flag] = s;
				swap(a,i,flag);
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
