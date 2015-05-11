package Chapter_6;

import java.util.Arrays;

public class InnerClassTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[10];
		for(int i=0;i<a.length;i++)
		{
			a[i]=(int) (100*Math.random());
		}
		Find.Fair exp=Find.findMaxMin(a);
		System.out.println(""+exp.getMax()+"\t"+exp.getMin());
		Arrays.sort(a);
		for(int i=0;i<a.length;i++)
		{
			System.out.print(a[i]+"\t");
		}
		

	}

}
