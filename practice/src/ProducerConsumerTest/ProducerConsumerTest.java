package ProducerConsumerTest;

public class ProducerConsumerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stack s = new Stack();
		Producer p = new Producer(s);
		Consumer c = new Consumer(s);
		
		p.start();
		c.start();
		
		
	}

}
