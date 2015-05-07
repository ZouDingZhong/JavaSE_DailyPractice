

import java.util.LinkedList;

public class Stack
{
	 LinkedList list = null;
	public Stack()
	{
		list = new LinkedList();
	}
	public boolean isEmpty()
	{
		return list.isEmpty();
	}
	public void push(Object o)
	{
		list.add(o);
	}
	public Object pop()
	{
		Object oo = null;
		try{oo = list.getLast();}
		catch(Exception e)
		{
			return null;
		}
		if(oo==null) return null; 
		list.removeLast();
		return oo;
		
	}	
}
