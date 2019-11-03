package Week2;

public class Leetcode_105 {
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode root = buildTree(preorder, inorder);
    }

    /**
     * 简单递归解法，哈哈，和英文网站第一名的相似
     * 执行用时 :15 ms, 在所有 java 提交中击败了54.13%的用户
     * 内存消耗 :42.7 MB, 在所有 java 提交中击败了23.23%的用户
     * @param preorder
     * @param inorder
     * @return
     */
    private static TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        return root;
    }

    private static TreeNode build(int[] preorder, int l1, int r1, int[] inorder, int l2, int r2) {
        if (l1 > r1 || l2 > r2)
            return null;
        TreeNode root = new TreeNode(preorder[l1]);
        int rootLoc = 0;
        for (int i = l2; i <= r2 ; i++) {
            if (inorder[i] == preorder[l1]) {
                rootLoc = i;
                break;
            }
        }
        root.left = build(preorder, l1 + 1, l1 + (rootLoc - l2), inorder, l2, rootLoc - 1);
        root.right = build(preorder, l1 + (rootLoc - l2) + 1, r1, inorder, rootLoc + 1, r2);
        return root;
    }
}
