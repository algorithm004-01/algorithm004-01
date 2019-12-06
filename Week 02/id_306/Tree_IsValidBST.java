import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by LynnSun on 2019/10/27.
 */
public class Tree_IsValidBST {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    /**
     * 递归
     * @param node
     * @param lower
     * @param upper
     * @return
     */
    private boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) return true;

        int val = node.val;
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;

        if (! helper(node.left, lower, val)) return false;
        if (! helper(node.right, val, upper)) return false;
        return true;
    }

    /**
     * 树遍历，用栈的方式，迭代，中序
     * @param root
     * @return
     */
    public boolean helper_stack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<> ();
        /*这句是为了让整个程序能运行起来。
        第一次进入循环的时候，if (root.val <= inorder) return false;
        这里比较的是初始的inorder和最左节点的值。我们无法预先知道最左节点的大小，
        因此这里设置inorder为-Double.MAX_VALUE是C++允许的最小值，保证这里root.val <= inorder 一定不成立。**/
        double inorder = - Double.MAX_VALUE;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= inorder) return false;
            inorder = root.val;
            root = root.right;
        }
        return true;
    }

}
