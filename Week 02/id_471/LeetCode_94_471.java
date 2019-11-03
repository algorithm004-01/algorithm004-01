class Solution {
    List<Integer> results = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null){
            return results;
        }
        dfs(root);
        return results;
    }
    
    public void dfs(TreeNode root){
        
        if(root.left != null){
            dfs(root.left);
        }
        
        results.add(root.val);
        
        if(root.right != null){
            dfs(root.right);
        }
    }
}