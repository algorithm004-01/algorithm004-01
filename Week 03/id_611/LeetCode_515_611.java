import java.util.ArrayList;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=515 lang=java
 *
 * [515] 在每个树行中找最大值
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
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import javax.swing.tree.TreeNode;

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> data = new ArrayList<>();
        if(root == null) return data;
        bfsFunc(data,root);
        return data;
    }

    public void bfsFunc(List<Integer> data,TreeNode node){
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(node);
        while(!queue.isEmpty()){
            int max = Integer.MIN_VALUE;
            int size = queue.size();
            while(size-- > 0){
                TreeNode tmpNode = queue.poll();
                if(tmpNode.left != null) queue.offer(tmpNode.left);
                if(tmpNode.right != null) queue.offer(tmpNode.right);
                
                max = max < tmpNode.val ? tmpNode.val : max; 
            }
            data.add(max);
        }
        
        
    }
}
// @lc code=end

