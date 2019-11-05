import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.graalvm.compiler.lir.LIRInstruction.Def;
import org.graalvm.compiler.nodes.java.ArrayLengthNode;

/**
 * LeetCode_94_576
 */
public class LeetCode_94_576 {
    //1. 官方解法，递归的方法，O(n)
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    } 
    
    public void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left, res); 
            }
            res.add(root.val);
            if (root.right != null) {
                helper(root.right, res);
            }
        }
    }

    /*
    2. 基于栈的遍历，与递归方法类似，区别是使用了栈，感觉较递归有些绕,
    但是国际站票高得都用得这种解法，记下来
     */

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();//通过判断条件如果右儿子为空，就会一直出栈元素
            res.add(curr.val);
            curr = curr.right;// 指向右儿子
        }
        return res;
    } 
}


