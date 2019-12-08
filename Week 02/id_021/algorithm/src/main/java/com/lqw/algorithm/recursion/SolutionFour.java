package com.lqw.algorithm.recursion;

import java.util.Arrays;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 *
 * 思考：
 * 1、递归，左子树成二叉树，右子树成二叉树
 */
public class SolutionFour {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return reverseBuildTree(preorder, inorder);

    }

    private TreeNode reverseBuildTree(int[] preorder, int[] inorder) {
        //terminator终止条件
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        //process 处理逻辑
        TreeNode root = new TreeNode(preorder[0]);
        int rootootIndexOfInorder = getRootIndexOfInorder(preorder[0], inorder);
        int[] leftPreorde = Arrays.copyOfRange(preorder, 1, rootootIndexOfInorder + 1);
        int[] leftInOrder = Arrays.copyOfRange(inorder, 0, rootootIndexOfInorder);
        int[] rightPreorde = Arrays.copyOfRange(preorder, rootootIndexOfInorder + 1, preorder.length);
        int[] rightInOrder = Arrays.copyOfRange(inorder, rootootIndexOfInorder + 1, inorder.length);

        //drill down 下探到下一层
        //左子树
        TreeNode left = reverseBuildTree(leftPreorde, leftInOrder);

        //右子树
        TreeNode right = reverseBuildTree(rightPreorde, rightInOrder);

        root.left = left;
        root.right = right;

        //清理当前层
        return root;

    }

    private int getRootIndexOfInorder(int rootValue, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            if (rootValue == inorder[i]) {
                return i;
            }
        }
        return 0;
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
