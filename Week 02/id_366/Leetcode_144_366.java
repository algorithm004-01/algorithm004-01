/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] 二叉树的前序遍历
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;               
    }
    
    private void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            res.add(root.val);
            if (root.left != null) {
                helper(root.left, res);
            }
            if (root.right != null) {
                helper(root.right, res);
            }
        } 
    }
}
// @lc code=end

