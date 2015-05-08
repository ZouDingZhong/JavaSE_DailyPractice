package dataStruct;

import java.util.Scanner;

public class _03_03 {

	public static String print="";
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int amount = Integer.parseInt(input.nextLine());
		String[][] s = new String[2*amount][];
		TreeNode[] tree = new TreeNode[amount];
		
		TreeNode markNode = null ;
		int treeNodeNumber = 0;
		int state =0;
		String str;
		for(int i=0;i<2*amount;i++)
		{
			str = input.nextLine();
			s[i] = str.split(" "); 
		}
//		this is the test of input
//		for(int i=0;i<s.length;i++)
//		{
//			for(int j=0;j<s[i].length;j++)
//			{
//				System.out.println(s[i][j]);
//			}
//			System.out.println();
//		}
				
		for(int i=0;i<s.length;i++)
		{
			if(i==0)
			{
				if(s[i].length==2)
				{
					tree[treeNodeNumber] = new TreeNode();
					tree[treeNodeNumber].setValue(s[i][1]);
					state = 0;
					markNode = tree[treeNodeNumber];
					treeNodeNumber++;
				}
				else
				{
					System.out.println("input error!");
				}
			}
			else
			{
				if(s[i].length==2)
				{
					tree[treeNodeNumber] = new TreeNode();
					tree[treeNodeNumber].setValue(s[i][1]);
					
					if(markNode.getlNode()==null)
					{
						markNode.setlNode(tree[treeNodeNumber]);
						tree[treeNodeNumber].setfNode(markNode);
					}
					else
					{
						markNode.setrNode(tree[treeNodeNumber]);
						tree[treeNodeNumber].setfNode(markNode);
					}
					state = 0;
					markNode = tree[treeNodeNumber];
					treeNodeNumber++;
				}
				else
				{
					if(state==0)
					markNode = tree[treeNodeNumber-1].getfNode();
					else
					{
						if(markNode.getrNode()==null)
						{
							
						}
						else
						{
							markNode = markNode.getfNode();
						}
					}
					state = 1;
				}
			}
						
		}
		showTree(tree[0]);
		print = print.substring(0, print.length()-1);
		System.out.println(print);
//		for(int j=0;j<tree.length;j++)
//		{
//			System.out.println(tree[j].getValue());
//			showTreeNode(tree[j]);
//		}
		
	}
	
	public static void showTreeNode(TreeNode node)
	{
		System.out.println("left is"+node.getlNode());
		System.out.println("right is"+node.getrNode());
		System.out.println("this is"+node);
		System.out.println("father is"+node.getfNode());
	}
	
	public static void showTree(TreeNode node)
	{
//		TreeNode l = node.getlNode();
//		TreeNode r = node.getrNode();
//		
//		if(l!=null)
//		{
//			showTree(l);
//		}
//		if(r!=null)
//		{
//			showTree(r);
//		}
		if(node!=null)
		{
			showTree(node.getlNode());
			showTree(node.getrNode());
			print+=node.getValue()+" ";
		}
	}

}
class TreeNode
{
	private TreeNode lNode=null;
	private TreeNode rNode=null;
	private String value;
	private TreeNode fNode=null;
	
	public TreeNode getfNode() {
		return fNode;
	}
	public void setfNode(TreeNode fNode) {
		this.fNode = fNode;
	}
	public TreeNode getlNode() {
		return lNode;
	}
	public void setlNode(TreeNode lNode) {
		this.lNode = lNode;
	}
	public TreeNode getrNode() {
		return rNode;
	}
	public void setrNode(TreeNode rNode) {
		this.rNode = rNode;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	public String toString()
	{
		return "TreeNode:[value]:"+this.value;
	}
}
