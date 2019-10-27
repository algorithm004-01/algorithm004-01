class Solution {
    private List<Integer> results = new ArrayList<>();
    
    public List<Integer> postorder(Node root) {
        dfs(root);
        return results;
    }
    
    public void dfs(Node root){
        if (root == null){
            return;
        }
        
        for (Node node : root.children){
            dfs(node);
        }
        results.add(root.val);
        
    }
    
}