

public class _7 {

	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		for(int i=0;i<5;i++)
		{
			queue.push(i);
		}
		while(!queue.isEmpty())
		{
			System.out.println(queue.pop());
		}
	}
	
}
class MyQueue
{
	private Stack s1 = new Stack();
	private Stack s2 = new Stack();
	public void push(Object o)
	{
		s1.push(o);
	}
	public Object pop()
	{
		if(this.isEmpty())
		return null;
		Object o = null;
		if(s2.isEmpty())
		{
			while(!s1.isEmpty())
			{
				o = s1.pop();
				s2.push(o);
			}
		}
		return s2.pop();
	}
	public boolean isEmpty()
	{
		return (s1.isEmpty()&&s2.isEmpty());
	}
}