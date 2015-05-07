

public class _9 {

	public static void main(String[] args) {
		System.out.println("test");
		for(int i=1;i<8;i++)
		{
			System.out.println(getFBNQ(i));
		}
	}
	public static int getFBNQ(int n)
	{
		int[] a = new int [2];
		a[0] = 0;
		a[1] = 1;
		int f=a[0],l=a[1];
		if(n<=0)
		{
			System.exit(-1);
		}
		else if(n==1) return a[1];
		else
		{
			for(int i=0;i<n;i++)
			{
				l = f+l;
				f = l-f;
			}
		}
		return f;
	} 
}
