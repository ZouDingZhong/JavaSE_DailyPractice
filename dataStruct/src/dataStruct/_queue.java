package dataStruct;

import java.util.LinkedList;

public class _queue {

	public static void main(String[] args) {
		MyQueue stack = new MyQueue();
		for(int i=0;i<5;i++)
		{
			stack.push(i);
		}
		Object o = stack.pop();
		while(o!=null)
		{
			System.out.println(o);
			o = stack.pop();
		}
		stack.push(333);
		System.out.println(stack.pop());
	}

}
class MyQueue
{
	static LinkedList list = null;
	public MyQueue()
	{
		list = new LinkedList();
	}
	public static void push(Object o)
	{
		list.addLast(o);
	}
	public static Object pop()
	{
		Object oo = null;
		try{oo = list.getFirst();}
		catch(Exception e)
		{
			return null;
		}
		if(oo==null) return null; 
		list.removeFirst();
		return oo;
		
	}	
}

