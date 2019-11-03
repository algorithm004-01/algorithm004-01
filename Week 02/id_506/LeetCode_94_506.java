class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> result = new ArrayList<>();
        
        Deque<Integer> stack = new ArrayDeque<>();
        
        process(stack, root, result);
        
        return result;
        
        
        
    }
    
    public void process(Deque<Integer> stack, TreeNode root, List<Integer> list){
        if (root == null){
            return;
        }
        stack.push(root.val);
        process(stack, root.left, list);
        list.add(stack.pop());
        
        process(stack, root.right, list);

        
        
    }
    
}