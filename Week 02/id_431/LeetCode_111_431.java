package easy;

import java.util.Stack;

/**
 * @author 潘磊明
 * @date 2019/10/24
 */
public class MinimumDepthOfBinaryTree {

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        return traserval(root, 1);
    }

    public int traserval(TreeNode node, int level){
        //叶子节点返回深度
        if (node != null && node.left == null && node.right == null) return level;
        int left = Integer.MAX_VALUE;
        if (node.left != null) {
            left = traserval(node.left, level + 1);
        }
        int right = Integer.MAX_VALUE;
        if (node.right != null) {
            right = traserval(node.right, level + 1);
        }
        return Math.min(left, right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
