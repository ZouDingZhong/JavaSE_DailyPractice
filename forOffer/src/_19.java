
public class _19 {

	public static void main(String[] args) {
		TreeNode tree_1 = new TreeNode(1);
		tree_1.setLeftTree(new TreeNode(2));
		tree_1.setRightTree(new TreeNode(3));
		tree_1.getLeftTree().setLeftTree(new TreeNode(4));
		tree_1.getLeftTree().setRightTree(new TreeNode(5));
		tree_1.getRightTree().setLeftTree(new TreeNode(6));
		tree_1.getRightTree().setRightTree(new TreeNode(7));
		
		mirrorTree(tree_1);
		printTree(tree_1);
		
	}
	public static void mirrorTree(TreeNode root)
	{
		TreeNode tem;
		if(root==null) System.exit(-1);
		if(root.getLeftTree()!=null)
		{
			mirrorTree(root.getLeftTree());
		}
		if(root.getRightTree()!=null)
		{
			mirrorTree(root.getRightTree());
		}
		if(root.getLeftTree()!=null||root.getRightTree()!=null)
		{
			tem = root.getLeftTree();
			root.setLeftTree(root.getRightTree());
			root.setRightTree(tem);
		}
	}
	public static void printTree(TreeNode tree)
	{
		if(tree==null) System.exit(-1);
		System.out.println(tree.getValue());
		if(tree.getLeftTree()!=null) printTree(tree.getLeftTree());
		if(tree.getRightTree()!=null) printTree(tree.getRightTree());
	}
}
