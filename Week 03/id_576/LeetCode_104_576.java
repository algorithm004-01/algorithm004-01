/**
 * LeetCode_104_576
 */
public class LeetCode_104_576 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }else {
            int left_height = maxDepth(root.left);
            int righ_height = maxDepth(root.right);
            return Math.max(left_height, righ_height) + 1;
        }
    }
}