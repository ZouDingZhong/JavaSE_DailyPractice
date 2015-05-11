package practice;

public class Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int qian=0,hou=1,i,m;
//		for(i=1;i<=20;i++){
//			System.out.println("di"+i+"geyueshi:"+hou);
//			m=qian;
//			qian=hou;
//			hou=m+hou;
//		}
//		
//		
//		
//		int i,j,flag=1;
//		for(i=101;i<201;i++){
//			flag=1;
//			for(j=2;j<Math.sqrt(i);j++){
//				if(i%j==0)
//					flag=0;
//			}
//			if(flag==1)
//				System.out.println(i);
//		}
//		
//
//		
//		
//		int i,a,b,c;
//		for(i=152;i<1000;i++){
//			a=i/100;
//			b=i/10%10;
//			c=i%10;
//			if((int)Math.pow( a, 3)+(int)Math.pow( b, 3)+(int)Math.pow( c, 3)==i){
//				System.out.println(i);
//			}
//		}
//		
//		
//		
//		
		String s ="1,2;3,4,5;6,7,8";
		String[] a =s.split(";");
		String[][] b = new String [3][];
	
		double[][] d = new double[3][];
		for(int i=0;i<3;i++)
		{
			b[i] = a[i].split(",");
		}	
		Double[][] c =new Double[3][];
		for(int i2=0;i2<3;i2++)
		{c[i2]=new Double[b[i2].length];
		{d[i2]=new double[b[i2].length];
	
		}
		for(int i1=0;i1<3;i1++)
		{
			for(int j=0;j<b[i1].length;j++)
			{
			 c[i1][j]=Double.parseDouble(b[i1][j]);
			 d[i1][j]=(double)c[i1][j];
		    }
		}
		for(int k=0;k<3;k++)
		{
			for(int j=0;j<d[k].length;j++)
			{
				System.out.println(d[k][j]);
			}	
		}
		
	}

}
}
