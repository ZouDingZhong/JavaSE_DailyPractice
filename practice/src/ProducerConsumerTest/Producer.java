package ProducerConsumerTest;

class Producer extends Thread {
	Stack s;
	public Producer(Stack s)
	{
		this.s = s;
	}
	public synchronized void run()
	{
		for(int i=0;i<20;i++)
		{
			s.push(new Produce(i));
			try {
				Thread.sleep((int)(Math.random())*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("生产了产品"+i);
		}
	}
	

}
