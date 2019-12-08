package id_511;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @Description: 二叉树的层次遍历
 * @author: bingyu
 * @date: 2019/11/3 22:20
 */
public class LeetCode_102_511 {

    public static class TreeNode{
        public int val;
        public TreeNode left,right;

        public TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    List<List<Integer>> levels = new ArrayList<List<Integer>>();

    //DFS递归
    //自己写不出来，目前反复看题解：
    public void helper(TreeNode node, int level) {
        // start the current level
        if (levels.size() == level)
            levels.add(new ArrayList<Integer>());

        // fulfil the current level
        levels.get(level).add(node.val);

        // process child nodes for the next level
        if (node.left != null)
            helper(node.left, level + 1);
        if (node.right != null)
            helper(node.right, level + 1);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return levels;
        helper(root, 0);
        return levels;
    }




    /*public static void inOrder(TreeNode root) {

        TreeNode cur = root;
        // terminator 1.终止条件
        if (cur == null) {
            // process result
            return;
        }

        // process current logic
        if (cur.left != null) {
            inOrder(cur.left);
        }

        System.out.print(cur.val + ",");

        // drill down  进入下一层
        if (cur.right != null) {
            inOrder(cur.right);
        }

    }*/

    //DFS
    public static int numIslands(char[][] grid) {

        return 0;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode a = new TreeNode(9);
        TreeNode b = new TreeNode(20);
        TreeNode c = new TreeNode(15);
        TreeNode d = new TreeNode(7);
        root.left = a;
        root.right = b;
        root.right.left = c;
        root.right.right = d;
    }
}
