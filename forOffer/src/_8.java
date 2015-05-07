

public class _8 {
	public static void main(String[] args)
	{
		int[] a = {1,1,2,3,4,5,6};
		System.out.println(getMin(a,0,a.length-1));
	}
	public static int getMin(int[]a,int left,int right)
	{
		int l = left,r = right;
		if(a[l]<a[r])
		{
			System.out.println("input error");
			System.exit(-1);
		}
		while(true)
		{
			if(l==r-1)
			break;
			if(a[(l+r)/2]==a[l]&&a[(l+r)/2]==a[l])
			{
				return _getMin(a);
			}
			if(a[(l+r)/2]>=a[l])
			{
				l = (l+r)/2;
			}
			else if(a[(l+r)/2]<a[r])
			{
				r = (l+r)/2;
			}
		}
		return a[r];
	}
	private static int _getMin(int[] a) {
		int min = a[0];
		for(int i=0;i<a.length;i++)
		{
			if(a[i]<min)
			{
				min = a[i];
			}
		}
		return min;
	}
}
