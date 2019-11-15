import java.util.HashMap;
import java.util.Map;

import javax.management.RuntimeErrorException;
import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    // 内层O(n)的查找，可以通过hash表降为O(1)
    private int[] preorder;
    private Map<Integer,Integer> hash;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length) {
            throw new RuntimeException("Incorrect input data.");
        }

        this.preorder = preorder;
        this.hash = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            this.hash.put(inorder[i], i);
        }

        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preodrder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }

        int pivot = preodrder[preLeft];
        TreeNode root = new TreeNode(pivot);
        int pivotIndex = hash.get(pivot);

        // while (inorder[pivotIndex] != pivot) {
        //     pivotIndex++;
        // }
        root.left = buildTree(preodrder, preLeft + 1, preLeft + pivotIndex - inLeft, inorder, inLeft, pivotIndex-1);
        root.right = buildTree(preodrder, preLeft + pivotIndex - inLeft + 1, preRight, inorder, pivotIndex + 1, inRight);
        return root;
    }
}