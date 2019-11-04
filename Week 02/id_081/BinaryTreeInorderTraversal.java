import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * BinaryTreeInorderTraversal
 */
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList()<>();
        Stack<TreeNode> stack = new Stack()<>();
        TreeNode cur = root;
        while(cur!=null || !stack.isEmpty()){
            if(cur != null){
                stack.push(cur);
                cur = cur.left;
            }else{
                TreeNode node = stack.pop();
                list.add(node.val);
                cur = node.right;
            }
        }
        return list;
    }
}