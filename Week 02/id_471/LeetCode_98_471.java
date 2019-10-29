class Solution {
    private TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        if (root == null){
            return true;
        }
        
        if (!isValidBST(root.left)){
            return false;
        }
        
        if (prev != null && prev.val >= root.val){
            return false;
        }
        prev = root;
        
        return isValidBST(root.right);
    }
}