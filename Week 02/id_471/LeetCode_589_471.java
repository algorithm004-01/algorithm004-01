class Solution {
    private List<Integer> results = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        dfs(root);
        return results;
    }
    
    public void dfs(Node root){
        if(root == null){
            return;
        }
        results.add(root.val);
        for(Node node : root.children){
            dfs(node);
        }
        
    }
}