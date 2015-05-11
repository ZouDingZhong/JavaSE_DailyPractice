package Chapter_5;

public class PracticeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Person[] exp = new Person[2];
    exp[0] = new Student("Bill");
    exp[0].printClass();
    exp[0].jichengTest();
    Student e=(Student)exp[0];
    e.addTest();
    ((Student)exp[0]).addTest();
    ((Student)exp[0]).printClass();
    System.out.println(""+exp[0]);
    System.out.println(""+(Student)exp[0]);
    
    Person_2Test test = new Person_2Test("zou");
    
    System.out.println(""+test);
    StudentTest e_2 = new StudentTest("Last") ;
    System.out.println(""+e_2);
	}
//	
//	Person yi = new Student("zou");
//	Person r;
//    if(yi instanceof Student)
//    {
//    	System.out.println("yi shi");
//    }


}