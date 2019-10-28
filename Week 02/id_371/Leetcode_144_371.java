import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-10-26 11:29
 **/

public class Leetcode_144_371 {
    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    /**
     * 实践2.通过栈来模拟递归的过程
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) { //相当于递归出口
            //1.将根节点元素出栈
            TreeNode node = stack.pop();
            result.add(node.val);
            //2.将子节点压入栈中,先右后左(出栈先左后右)
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }

        return result;
    }

    /**
     * 原解1.递归
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        return recur(root, result);
    }

    private List<Integer> recur(TreeNode root, List<Integer> result) {
        //1.递归出口
        if (root != null) {
            //2.处理当前层
            result.add(root.val);
            //3.向下一层
            if (root.left != null) recur(root.left, result);

            if (root.right != null) recur(root.right, result);
        }
        return result;
    }


}
