package Exception;

public class ExceptionTest {
	
	static void test(int x) throws MyException
	{
		if(x==0) throw new MyException("被除数为0",100);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 0;
		try
		{
			test(x);
		}
		catch (MyException e)
		{
			System.out.println("密码错误，请重试  错误代码："+e.getID());
	        e.printStackTrace();
		}

	}

}
