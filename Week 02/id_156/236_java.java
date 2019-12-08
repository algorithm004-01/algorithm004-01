class Solution {
    private TreeNode ans;
    
    public Solution() {
        this.ans = null;
    }
    
    private Boolean reverseTree(TreeNode root, TreeNode p, TreeNode q) {
        int mid = 0;
        int right = 0;
        int left = 0;
        
        if (null == root) {
            return false;
        }
        
        if (root.val == p.val || root.val == q.val) {
            mid++;
        }
        
        right = this.reverseTree(root.right, p, q) ? 1 : 0;
        left  = this.reverseTree(root.left, p, q) ? 1 : 0;
        
        if (mid + right + left > 1) {
            this.ans = root;
        }
        
        return (mid + right+ left) > 0;
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //递归处理
        this.reverseTree(root, p, q);
        return this.ans;
    }
}
