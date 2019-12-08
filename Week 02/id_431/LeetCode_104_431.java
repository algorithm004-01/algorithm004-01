package easy;

/**
 * @author 潘磊明
 * @date 2019/10/24
 */
public class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        return traserval(root, 0);
    }

    public int traserval(TreeNode node, int level){
        if (node == null) return level;
        int left = traserval(node.left, level + 1);
        int right = traserval(node.right, level + 1);
        return Math.max(left, right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
