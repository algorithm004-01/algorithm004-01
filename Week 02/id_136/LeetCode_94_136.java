

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode_94_136 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> l = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack();
        TreeNode node = root;

        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                if (!stack.isEmpty()) {
                    node = stack.pop();
                    l.add(node.val);
                    node = node.right;
                }
            }
        }
        return l;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
