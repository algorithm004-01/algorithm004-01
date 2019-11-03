public class LeetCode_236_LowestCommonAncestorOfABinaryTree {
    public static void main(String[] args) {
        Solution solution = new LeetCode_236_LowestCommonAncestorOfABinaryTree().new Solution();
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

            // terminate
            if (root == null || root == p || root == q) return root;
            // drill down
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            // process current logic
            return left == null ? right : right == null ? left : root;
        }
    }
}