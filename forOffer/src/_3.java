

public class _3 {

	public static void main(String[] args) {
		int[][] a = new int[5][5] ;
		a[0] = new int[]{1, 4,21,31,44};
		a[1] = new int[]{5,10,31,41,49};
		a[2] = new int[]{7,19,33,44,55};
		a[3] = new int[]{8,22,40,51,60};
		a[4] = new int[]{9,30,44,60,70};
//		for(int i=0;i<5;i++)
//		{
//			for(int j=0;j<5;j++)
//			{
//				System.out.print(a[i][j]+"    ");
//			}
//			System.out.println();
//		}
		System.out.println(find(a,5,5,0));
	}
	public static boolean find(int[][] a ,int rows,int cols,int b)
	{
		boolean found = false;
		if(a!=null&&rows>0&&cols>0)
		{
			int row = 0;
			int col = cols - 1;
			while(row<rows&&col>0)
			{
				if(a[row][col]==b)
				{
					found = true;
					break;
				}
				if(a[row][col]<b)
				{
					row++;
				}
				if(a[row][col]>b)
				{
					col--;
				}
			}
		}
		return found;
	}
	public void initiArray(int[][] a,int row ,int col)
	{
		int i = 0;
		int j = 0;
		int temp;
		while(i<row||j<col)
		{
			if(i==0&&j==0)
			{
				a[i][j] = (int)(Math.random()*100);		
				i++;
			}
			temp = (int)(Math.random()*100);
				
		}
	}

}
