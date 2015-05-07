
public class _18 {

	public static void main(String[] args) {
		TreeNode tree_1 = new TreeNode(1);
		tree_1.setLeftTree(new TreeNode(2));
		tree_1.setRightTree(new TreeNode(3));
		tree_1.getLeftTree().setLeftTree(new TreeNode(4));
		tree_1.getLeftTree().setRightTree(new TreeNode(5));

//		TreeNode tree_2 = null;
		TreeNode tree_2 = new TreeNode(2);
		tree_2.setLeftTree(new TreeNode(4));
		tree_2.setRightTree(new TreeNode(5));
		System.out.println(new _18().doesContain(tree_1,tree_2));
		
	}
	public boolean doesContain(TreeNode tree_1,TreeNode tree_2)
	{
		boolean isContain = false;
		if(tree_1==null||tree_2==null)
		{
			System.out.println("NULLPOINT Error");
			System.exit(-1);
		}
		if(tree_1.getValue()==tree_2.getValue())
		{
			isContain = doesAllContain(tree_1,tree_2);
			if(isContain)return true;
		}
		if(tree_1.getLeftTree()!=null)
		{
			isContain = doesContain(tree_1.getLeftTree(),tree_2);
			if(isContain)return true;
		}
		if(tree_1.getRightTree()!=null)
		{
			isContain = doesContain(tree_1.getRightTree(),tree_2);
			if(isContain)return true;
		}
		return isContain;
	}
	boolean doesAllContain(TreeNode tree_1, TreeNode tree_2) {
		boolean isAllContain = true;
		if(tree_1==null||tree_2==null)
		{
			System.out.println("null Error");
			System.exit(-1);
		}
		if(tree_1.getValue()!=tree_2.getValue())return false;
		if(tree_2.getLeftTree()!=null)
		{
			if(tree_1.getLeftTree()!=null)
			{
				isAllContain = doesAllContain(tree_1.getLeftTree(),tree_2.getLeftTree());
			}
		}
		if(tree_2.getRightTree()!=null)
		{
			if(tree_1.getRightTree()!=null)
			{
				isAllContain = doesAllContain(tree_1.getRightTree(),tree_2.getRightTree());
			}
		}
		return isAllContain;
	}
}
class TreeNode
{
	private int value;
	private TreeNode leftTree = null;
	private TreeNode rightTree = null;
	TreeNode(int v)
	{
		value = v;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public TreeNode getLeftTree() {
		return leftTree;
	}
	public void setLeftTree(TreeNode leftTree) {
		this.leftTree = leftTree;
	}
	public TreeNode getRightTree() {
		return rightTree;
	}
	public void setRightTree(TreeNode rightTree) {
		this.rightTree = rightTree;
	}
	
}