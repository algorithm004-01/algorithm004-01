import java.util.*;
/**
 * 从前序与中序遍历序列构造二叉树
 */
public class Solution {
    /**
     * 从前序与中序遍历序列构造二叉树
     */
    private Map<Integer, Integer> map = new HashMap<>();
    private int preorderIndex = 0;
    private int[] preorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length)
            return null;
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        return buildTreeHelp(0, inorder.length - 1);
    }

    private TreeNode buildTreeHelp(int start, int end) {
        if (start > end)
            return null;
        int rootVal = preorder[preorderIndex];
        int index = map.get(rootVal);
        TreeNode node = new TreeNode(rootVal);
        preorderIndex++;
        node.left = buildTreeHelp(start, index - 1);
        node.right = buildTreeHelp(index + 1, end);
        return node;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}