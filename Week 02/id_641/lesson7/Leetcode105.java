package vip.ruoyun.week2.lesson7;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 这道题如果不看题解的话,还是没有想法
 */
public class Leetcode105 {

    //
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int pre_idx = 0;
    int[] preorder;
    int[] inorder;
    HashMap<Integer, Integer> idx_map = new HashMap<>();


    public TreeNode helper(int in_left, int in_right) {
        if (in_left == in_right)
            return null;

        //得到
        int root_val = preorder[pre_idx];
        TreeNode root = new TreeNode(root_val);

        int index = idx_map.get(root_val);

        pre_idx++;
        //得到左节点
        root.left = helper(in_left, index);
        //得到右节点
        root.right = helper(index + 1, in_right);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;

        int idx = 0;
        //中序的值保存到 map 中,
        for (Integer val : inorder)
            idx_map.put(val, idx++);

        //中序遍历 开始已经是左节点
        return helper(0, inorder.length);
    }
}
