
public class LockTest implements Runnable{

	private int i = 100;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		LockTest one = new LockTest();
		Thread tone = new Thread(one);
		tone.start();
		Thread.sleep(10);
		System.out.println("main  "+one.i);
		Thread.sleep(2000);
		one.m2();
//		Thread.sleep(3000);
		Thread.sleep(3000);
		System.out.println("main  "+one.i);
	}

	public synchronized void m1() throws InterruptedException
	{
//		Thread.sleep(10);
		i = 1000;
		Thread.sleep(7000);
		System.out.println("m1  "+i);
	}
	
	public synchronized void m2() throws InterruptedException
	{
		i = 2000;
//		Thread.sleep(2000);
		System.out.println("m2  "+i);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub

		try {
			m1();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
