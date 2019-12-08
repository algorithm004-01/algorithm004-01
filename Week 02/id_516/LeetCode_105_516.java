package com.hjj.leetcode.oct27;

import java.util.HashMap;

public class LeetCode105 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    class Solution {
        int nowIndex = 0;
        int[] preOrder;
        int[] inOrder;
        HashMap<Integer, Integer> idxMap = new HashMap<>();


        public TreeNode recur(int leftIndex,int rightIndex) {
            // terminated
            if (leftIndex == rightIndex) {
                return null;
            }
            // process
            int rootVal = preOrder[nowIndex];
            TreeNode root = new TreeNode(rootVal);
            int index = idxMap.get(rootVal);

            nowIndex++;
            // drill down
            root.left = recur(leftIndex,index);
            root.right = recur(index + 1,rightIndex);
            return root;
        }


        public TreeNode buildTree(int[] preorder, int[] inorder) {
            this.preOrder = preorder;
            this.inOrder = inorder;
            int idx = 0;
            // idx
            for (Integer val : inorder)
                idxMap.put(val, idx++);
            return recur(0, inorder.length);
        }
    }
}
