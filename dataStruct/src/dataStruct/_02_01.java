package dataStruct;

import java.util.Scanner;

public class _02_01 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int firstAddress = input.nextInt();
		int size = input.nextInt();
		int amount = input.nextInt();
		int address;
		Node first;
		Node node;
		int cur, value, next;
		
		Node [] n = new Node[size];
		for(int i=0;i<size;i++)
		{
			cur = input.nextInt();
			value = input.nextInt();
			next = input.nextInt();
			n[i] = new Node(cur,value,next);
		}
		first = findThis(n,firstAddress);
//		node = first;
//		while(node!=null)
//		{
//			System.out.println(node.getValue());
//			node = findThis(n,node.getNext());
//		}
		
		int thatAddress;
		thatAddress = getThatAddress(n,firstAddress,amount);
		first = upsideDown(n,first,amount);
		findThis(n,firstAddress).setNext(thatAddress);
		
		node = first;
		while(node!=null)
		{
			System.out.printf("%05d",node.getCur());
			System.out.print(" "+node.getValue()+" ");
			if(node.getNext()!=-1)System.out.printf("%05d",node.getNext());
			else System.out.print(-1);
			System.out.println();
			node = findThis(n,node.getNext());
		}
		
	}

	
	public static int getThatAddress(Node[]a,int firstAddress,int amount)
	{
		Node node = findThis(a,firstAddress);
		for(int i=1;i<amount;i++)
		{
			node = findThis(a,node.getNext());
		}
		return node.getNext();
	}
	public static Node upsideDown(Node[]a,Node first,int amount)
	{
		if(amount==1)
		{
			return first;
		}
		Node node = first;
		for(int i=1;i<amount;i++)
		{
			node = findThis(a,node.getNext());
		}
		node.setNext(upsideDown(a,first,amount-1).getCur());
		return node;
	}
	public static Node findThis(Node[]a,int cur)
	{
		if(cur == -1)
		{
			return null;
		}
		int i=0;
		for( ;i<a.length;i++)
		{
			if(a[i].getCur()==cur) 
			break;
		}
		return a[i];
	}
}
class Node
{
	public Node(int cur,int value,int next)
	{
		this.cur = cur;
		this.value = value;
		this.next = next;
	}
	public int getCur() {
		return cur;
	}
	public void setCur(int cur) {
		this.cur = cur;
	}
	public int getNext() {
		return next;
	}
	public void setNext(int next) {
		this.next = next;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	private int cur;
	private int next;
	private int value;
}
