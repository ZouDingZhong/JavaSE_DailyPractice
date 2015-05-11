package Array;
import java.util.*;
public class ArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       ArrayList staff = new ArrayList();
       staff.add(new Duixiang("yi",1));
       staff.add(0,new Duixiang("er",2));
       staff.add(new Duixiang("san",3));
//       staff.remove(1);
       System.out.println(staff.size());
       for(int i=0;i<staff.size();i++)
       {
    	   System.out.println((Duixiang)staff.get(i));
       }
       System.out.println("********************");
       
       Duixiang[] listtest = new Duixiang[5];
       listtest[0]=new Duixiang("1",100);
       listtest[1]=new Duixiang("2",11);
       listtest[2]=new Duixiang("3",1);
       listtest[3]=new JiCheng("4",0);
       listtest[4]=new JiCheng("5",1);
       Arrays.sort(listtest);
       for(int i=0;i<listtest.length;i++)
       {
    	   System.out.println(listtest[i]);
       }
	}

}
