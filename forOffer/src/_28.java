
public class _28 {

	public static void main(String[] args) {
		char[] str = {'a','b','c','d'};
		printAllSort(str,0);
	}
	public static void printAllSort(char[] str,int start)
	{
		if(str == null) throw new RuntimeException("Invalid input");
		if(start==str.length)
		{
			for(char c : str)
			{
				System.out.print(c+"   ");
			}
			System.out.println();
		}
		else
		{
			for(int i=start;i<str.length;i++)
			{
				swap(str,start,i);
				printAllSort(str,start+1);
				swap(str,start,i);
			}
		}
		
	}
	public static void swap(char[] str,int start,int i)
	{
		if(i==start)return;
		char swap;
		swap = str[start];
		str[start] = str[i];
		str[i] = swap;
	}
}
