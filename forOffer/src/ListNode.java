
public class ListNode
{
	private ListNode next = null;
	private Object value = null;
	
	public ListNode upside(ListNode first,int n)
	{
		if(n>first.getSize())
		{
			System.out.println("翻转数量越界，操作失败");
			return first;
		}
		ListNode node = first;
		ListNode thatNode = null;
		for(int i=0;i<n;i++)
		{
			node = node.next;
		}
		thatNode = _upside(first,n);
		first.setNext(node);
		return thatNode;
	}
	public ListNode _upside(ListNode first,int n)
	{
		ListNode node = first;
		if(n==1)return node;
		for(int i=1;i<n;i++)
		{
			node = node.next;
		}
	    node.next = _upside(first,n-1);
	    return node;
	}
	public void print()
	{
		ListNode node = this;
		while(node!=null)
		{
			System.out.println(node.value);
			node = node.next;
		}
		
	}
	public ListNode(Object o)
	{
		this.value = o;
	}
//	public void add(ListNode firstNode,ListNode addNode)
//	{
//		ListNode node = firstNode;
//		while(node.next!=null)
//		{
//			node = node.next;
//		}
//		node.next = addNode;
//	}
	public void add(ListNode addNode)
	{
		ListNode node = this;
		while(node.next!=null)
		{
			node = node.next;
		}
		node.next = addNode;
	}
	public void delete(ListNode deleteNode)
	{
		ListNode node = this;
		while(node.next!=deleteNode)
		{
			node = node.next;
		}
		if(node==null) return;
		node.next = deleteNode.next;
	}
	public ListNode find(Object o)
	{
		ListNode node = this;
		while(node.getValue()!=o&&(node!=null))
		{
			node = node.next;
		}
		return node;
		
	}
	public ListNode find(int i)
	{
		ListNode node = this;
		for(int j=0;j<i;j++)
		{
			node = node.getNext();
		}
		return node;
		
	}
	public int getSize()
	{
		int amount = 0;
		ListNode node = this.getNext();
		while(node!=null)
		{
			amount++;
			node = node.getNext();
		}
		return amount;
	}
	public ListNode getNext() {
		return next;
	}
	public void setNext(ListNode next) {
		this.next = next;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
//	public String toString()
//	{
//		return (String) this.value;
//	}
}