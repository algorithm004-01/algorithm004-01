import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层次遍历
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

    public void helper(TreeNode node,int level,List<List<Integer>> res){
        if(res.size() == level) res.add(new ArrayList<>());
        res.get(level).add(node.val);
        if(node.left != null) helper(node.left, level + 1, res);
        if(node.right != null) helper(node.right, level + 1, res);

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        //边界条件
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        helper(root, 0, res);
        return res;
    }

    // public List<List<Integer>> levelOrder(TreeNode root) {
    //     //边界条件
    //     List<List<Integer>> res = new ArrayList<>();
    //     if(root == null) return res;
    //     //迭代方式
    //     //使用队列的方式进行层级访问
    //     Queue<TreeNode> queue = new LinkedList<>();
    //     queue.offer(root);
        
    //     while(!queue.isEmpty()){
    //         int level = queue.size();
    //         List<Integer> subList = new ArrayList<>();
    //         for(int i = 0; i < level; i++){
    //             TreeNode node = queue.remove();
    //             if(node.left != null) queue.add(node.left);
    //             if(node.right != null) queue.add(node.right);
    //             subList.add(node.val);
    //         }
    //         res.add(subList);
    //     }
    //     return res;
    // }
}
// @lc code=end

