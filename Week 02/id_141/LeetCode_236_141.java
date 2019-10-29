package app;

/**
 * LowestCommonAncestor
 */
class LowestCommonAncestor {
    

    private TreeNode node;

    private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {
        if (currentNode == null) {
            return false;
        }
        int left = recurseTree(currentNode.left, p, q) ? 1 : 0;
        int right = recurseTree(currentNode.right, p, q) ? 1 : 0;
        int mid = (currentNode == p) || (currentNode == q) ? 1 : 0;
        if (mid + left + right >= 2) {
            this.node = currentNode;
        }
        return (mid + left + right > 0);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.recurseTree(root, p, q);
        return this.node;
    }
}
/**
 * Definition for a binary tree node.
 */ 
class TreeNode {  
    int val;
    TreeNode left;
    TreeNode right; 
    TreeNode(int x) { 
        val = x; 
    }
}