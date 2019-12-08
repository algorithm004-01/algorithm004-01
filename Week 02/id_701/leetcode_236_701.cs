public class TreeNode
{
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }
}
public class Solution
{
    public TreeNode LowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
    {
        if (root is null || root == p || root == q)
        {
            return root;
        }
        var left = this.LowestCommonAncestor(root.left, p, q);
        var right = this.LowestCommonAncestor(root.right, p, q);
        return left != null && right != null ? root : left ?? right;
    }
}