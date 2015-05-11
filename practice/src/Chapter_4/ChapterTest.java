package Chapter_4;
import java.util.*;
public class ChapterTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     System.out.println("Hello,World!");

     Employee[] emp = new Employee[3];
     emp[0] = new Employee("Bill",1000);
     emp[1] = new Employee();
     emp[2] = new Employee();
     for(int i = 0;i<3;i++)
     {
    	 Employee e = emp[i];
    	 e.printEmloyee();
     }
     System.out.println("**********************************");
     
//    this is chapter 5 test
     Employee[] staff = new Employee[10];
     Object[] arr = staff;
     for(int i =0;i<10;i++)
     {
//    	 ((Employee)arr[i]).addSalary(100);
     }
     staff[5]=new Employee();
     System.out.println(staff[5].getName()+"\t"+staff[5].getSalary());
	
     
     System.out.println(staff[5].getClass().getName());
     String className = "Employee";
     try{
     if(Class.forName(className).getName()==staff[5].getClass().getName())
     {
    	 System.out.println("forName test work!");
     }
	   }
     catch(Exception e)
     {
    	 System.out.println("forName test fail!");
     }
     System.out.println("*****************************");
     System.out.println("above is fail");
     
     // ArrayListTest
//     ArrayList stafflist = new ArrayList();
////     stafflist.ensureCapacity(2);
//     stafflist.set(0,new Employee("xiaoming",100));
//     stafflist.set(1,new Employee("yi",200));
//     System.out.println(stafflist.size());
//     stafflist.set(2, new Employee("bing",300));
//     System.out.println(stafflist.size());
     
  
	}

}
