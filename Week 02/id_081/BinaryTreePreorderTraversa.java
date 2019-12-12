/**
 * BinaryTreePreorderTraversa
 */
public class BinaryTreePreorderTraversa {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()) 
            if(cur != null){
                list.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }else 
                cur = stack.pop().right;
        return list;
    }
    
}