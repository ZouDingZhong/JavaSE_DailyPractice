package ProducerConsumerTest;

class Consumer extends Thread {
	Stack s ;
	public Consumer(Stack s)
	{
		this.s = s;
	}
	public synchronized void run()
	{
		for(int i=0;i<20;i++)
		{
		try {
			Thread.sleep((int)(Math.random())*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("消费了产品"+s.pop());
		}
	}
	

}
