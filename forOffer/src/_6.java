//没做出来 出错在递归条件处
public class _6 {

	public static void main(String[] args) {
		int [] pre = {1,2,4,7,3,5,6,8};
		int [] later = {4,7,2,1,5,3,8,6};
		BinaryTreeNode root = builtBinaryTree(pre,later,pre.length);
		System.out.println(root.getValue());
	}

	private static BinaryTreeNode builtBinaryTree(int[] pre, int[] later,int lenght) {
		if(pre==null||later==null||lenght<=0)
		{
			throw new RuntimeException("Invalid input");
		}
		return builtTreeNode(pre,0,lenght-1,later,0,lenght-1);
	}

	private static BinaryTreeNode builtTreeNode(int[] pre,int pStart,int pEnd,int[] later,int lStart,int lEnd) {
		BinaryTreeNode proot = new BinaryTreeNode();
		proot.setValue(pre[pStart]);
		if(pStart == pEnd) return proot;
		int lindex = lStart;
		while(pre[pStart] != later[lindex]) 
		{
			lindex++;
			if(lindex>lEnd) 
				{
					throw new RuntimeException("Invalid input");
				}
		}
		int lenght = lindex - lStart;
		proot.setLeftNode(builtTreeNode(pre,pStart+1,pStart+lenght,later,lStart,lStart+lenght-1));
		proot.setRightNode(builtTreeNode(pre,pStart+lenght+1,pEnd,later,lStart+lenght+1,lEnd));
		return proot;
	}

}
class BinaryTreeNode
{
	private int value;
	private BinaryTreeNode leftNode;
	private BinaryTreeNode rightNode;
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public BinaryTreeNode getLeftNode() {
		return leftNode;
	}
	public void setLeftNode(BinaryTreeNode leftNode) {
		this.leftNode = leftNode;
	}
	public BinaryTreeNode getRightNode() {
		return rightNode;
	}
	public void setRightNode(BinaryTreeNode rightNode) {
		this.rightNode = rightNode;
	}
}