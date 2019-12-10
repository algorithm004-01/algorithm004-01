class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        
        List<Integer> result = new ArrayList();
        
        process(root, result);
        return result;
    }
    
    public void process(TreeNode root, List<Integer> list){
        
        if (root == null){
            return;
        }
        
        list.add(root.val);
        
        process(root.left, list);
        process(root.right, list);
        
    }
}