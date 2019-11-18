class Solution {
    List<Integer> results = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        dfs(root);
        return results;
    }
    
    public void dfs(TreeNode root){
        if(root == null){
            return;
        }
        results.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }
    
}