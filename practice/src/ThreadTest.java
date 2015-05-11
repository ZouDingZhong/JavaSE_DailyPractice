import java.util.Date;


public class ThreadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		thread1 one = new thread1();
//        Thread tone = new Thread(one);
//        Thread ttwo = new Thread(one);
//        tone.setPriority(10);
//        ttwo.start();
        try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        one.stopThread();
		
	}
 public static class thread1 implements Runnable
    {

	 boolean b;
//		@Override
		public thread1()
		{
			super();
			b=true;
			
		}
		public void run() {
			// TODO Auto-generated method stub
			
			try {
				while(b)
				{
				Thread.sleep(1000);
//				for(int i=0;i<20;i++)
//				{
//				   System.out.println(i);
//				}
     			System.out.println(new Date());
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				return;
			}
			
		}
		public void stopThread()
		{
			b=false;
		}
	}

}
