import java.util.List;

//import A.C;


public class testJiCheng {

	public static void main(String[] args) {
//		t b = new B();
//		b.hehe();
//		List l;
		
		A a = new A();
		T t = a.getC();
		t.hehe();
		A.C ac = a.new C();
		ac.hehe();
//		A.C ac2 = new A.C();
//		ac2.hehe();
	}

}
interface T
{
	void hehe();
}
class A 
{
	class C implements T
	{
		public void hehe()
		{
			System.out.println("this is come from c");
		}
	}
	C getC()
	{
		return new C();
	}
	public void hehe()
	{
		System.out.println("this is from A");
	}
}
class B extends A
{
//	public void hehe()
//	{
//		System.out.println("this is from B");
//	}
}
