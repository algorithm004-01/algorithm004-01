package com.yiche;

/**
 * @auther: TKQ
 * @Title: InvertTree_226
 * @Copyright: Copyright (c) 2019
 * @Description:
 * @Company:
 * @Created: 2019-10-20 17:30
 */
public class InvertTree_226 {
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return root;
        }
        TreeNode temp = root.left ;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);invertTree(root.right);
        return root;
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
//runtime:0 ms
//memory:34.2 MB
