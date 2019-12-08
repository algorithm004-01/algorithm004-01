class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root,res);
        return res;
    }
    
    public void helper(TreeNode root, List<Integer> res) {
        if(root != null) {
            if(root.left != null){
                helper(root, res);
            } 
            res.add(root.val);
            if(root.right != null) {
                helper(root, res);
            }
        }
    }
}

public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    Stack<TreeNode> stack = new Stack();
    TreeNode curr = root;
    while(root is not null ||  !stack.isEmpty) {
        while(curr is not null) {
            stack.push(curr);
            curr = curr.left;
        }
        curr = stack.pop();
        res.add(curr.val);
        curr = curr.right;
    }
    return res;
}