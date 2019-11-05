import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * LeetCode_144_576
 */
public class LeetCode_144_576 {
    //1.  递归法, O(n), 根，左，右
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }
    public void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            res.add(root.val);
            if (root.left != null) {
                helper(root.left, res); 
            }
            if (root.right != null) {
                helper(root.right, res);
            }
        }
    }

    /**
     * 方法2，基于栈的遍历，根，左，右，自己没想出来，看了国际站排名最高的解答
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            res.add(curr.val);
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
        }
        return res;
    }

    //3. 国际站排名最高的解答
    public List<Integer> preorderTraversal3(TreeNode node) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> rights = new Stack<>();
        while (node != null) {
            list.add(node.val);
            if (node.right != null) {
                rights.push(node.right);
            }
            node = node.left;
            if (node == null && !rights.isEmpty()) {
                node = rights.pop();
            }
        }
        return list;
    }
}