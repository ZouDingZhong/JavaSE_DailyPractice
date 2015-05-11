package ProducerConsumerTest;

class Stack {
	
	private final int C_MAX = 10;
	private  Produce [] arr ;
	private int sum = 0;
	
	public Stack()
	{
		arr = new Produce[C_MAX];	
	}
	public synchronized Produce pop()
	{
		if(sum == 0)
		{
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.notify();
		sum--;
		return arr[sum];
	}
	public synchronized void  push(Produce p)
	{
		if(sum == (C_MAX-1))
		{
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.notify();
		sum++;
		arr[sum-1] = p;
	}

}
