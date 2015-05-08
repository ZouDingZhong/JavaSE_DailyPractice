package dataStruct;

import java.util.*;

public class _Stack {

	public static void main(String[] args) {
		MyStack stack = new MyStack();
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
class MyStack
{
	static LinkedList list = null;
	public MyStack()
	{
		list = new LinkedList();
	}
	public static void push(Object o)
	{
		list.add(o);
	}
	public static Object pop()
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
