

public class _5 {

	public static void main(String[] args) {
		ListNode first = new ListNode((int)(Math.random()*100));
		ListNode node = first;
		for(int i=0;i<5;i++)
		{
			node.setNext(new ListNode((int)(Math.random()*100)));
			node = node.getNext();
		}
		first.print();
		System.out.println("=============");
		Stack stack = new Stack();
		node = first;
		while(node!=null)
		{
			stack.push(node);
			node = node.getNext();
		}
		node = (ListNode)stack.pop();
		while(node!=null)
		{
			System.out.println(node.getValue());
			node = (ListNode)stack.pop();
		}
	}

}
