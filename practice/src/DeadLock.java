
public class DeadLock implements Runnable{
	static Object o1=new Object(),o2=new Object();
	private int flag;
	public static void main(String[] args) {
		DeadLock d1 = new DeadLock();
		DeadLock d2 = new DeadLock();
		d1.setFlag(0);
		d2.setFlag(1);
		Thread td1 = new Thread(d1);
		Thread td2 = new Thread(d2);
		td1.start();
		td2.start();
	}

	@Override
	public void run() {
		System.out.println("flag ="+flag);
		if(flag==0)
		{
			synchronized(o1)
			{
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized(o2)
				{
					System.out.println("flag==0 finish");
				}
			}
			
		}
		else if(flag == 1)
		{
			synchronized(o2)
			{
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized(o1)
				{
					System.out.println("flag==1 finish");
				}
			}
		}
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

}
