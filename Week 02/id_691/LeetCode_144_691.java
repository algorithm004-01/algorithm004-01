public List<Integer> inorderTraversal(TreeNode root) {
    LinkedList<TreeNode>  stack = new LinkedList<>();
    LinkedList<Integer> output = new LinkedList<>();
    if (root == null) return output;
    
    stack.add(root);
    
    while(stack != null || !stack.isEmpty()){
        TreeNode node = stack.pollLast();
        output.add(node.val);
        
        if(node.right is not null){
              stack.add(node.right);
         }
         
        if(node.left is not null){
            stack.add(node.left);
        }
    }
    return output;
}

//方法2
public class List<Integer> preorderInterval(TreeNode root) {
    List<Integer> res = new LinkedList<>();
    helper(root, res);
    return res;
}

public void helper(TreeNode root, List<Integer> res) {
    if(root == null) return ;
    res.add(root.val);
    helper(root.left ,res);
    helper(root.right, res);
}