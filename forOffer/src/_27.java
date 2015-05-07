
public class _27 {

	public static void main(String[] args) {
		TreeNode tree_1 = new TreeNode(5);
		tree_1.setLeftTree(new TreeNode(3));
		tree_1.setRightTree(new TreeNode(7));
//		tree_1.getLeftTree().setLeftTree(new TreeNode(2));
		tree_1.getLeftTree().setRightTree(new TreeNode(4));
		tree_1.getRightTree().setLeftTree(new TreeNode(6));
		tree_1.getRightTree().setRightTree(new TreeNode(8));
		
//		System.out.println(new _27().treeToList(tree_1).getValue());
		TreeNode first = new _27().treeToList(tree_1);
		TreeNode p = first;
		while(p!=null)
		{
			System.out.println(p.getValue());
			p = p.getRightTree();
		}
	}
	public TreeNode treeToList(TreeNode root)
	{
		if(root == null ) return null;
		TreeNode lmax = null;
		TreeNode rmin = null;
		if(root.getLeftTree()!=null)
		{
			lmax = getMax(root.getLeftTree());
			lmax.setRightTree(root);
			root.setLeftTree(lmax);
		}
		if(root.getRightTree()!=null)
		{
			rmin = getMin(root.getRightTree());
			rmin.setLeftTree(root);
			root.setRightTree(rmin);
		}
		TreeNode first = root;
		while(first.getLeftTree()!=null)
		{
			first = first.getLeftTree();
		}
		return first;
	}
	public TreeNode getMax(TreeNode root)
	{
		TreeNode lmax = null,rmin = root;
		if(root.getLeftTree()!=null)
		{
			lmax = getMax(root.getLeftTree());
			lmax.setRightTree(root);
			root.setLeftTree(lmax);
		}
		if(root.getRightTree()!=null)
		{
			rmin = getMin(root.getRightTree());
			rmin.setLeftTree(root);
			root.setRightTree(rmin);
		}
//		if(root.getRightTree()==null) rmin = root;
		return rmin;
	}
	public TreeNode getMin(TreeNode root) {
		TreeNode lmax = root,rmin = null;
		if(root.getLeftTree()!=null)
		{
			lmax = getMax(root.getLeftTree());
			lmax.setRightTree(root);
			root.setLeftTree(lmax);
		}
		if(root.getRightTree()!=null)
		{
			rmin = getMin(root.getRightTree());
			rmin.setLeftTree(root);
			root.setRightTree(rmin);
		}
//		if(root.getRightTree()==null) rmin = root;
		return lmax;
	}
}
