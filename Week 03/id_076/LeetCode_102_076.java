package week3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 采用BFS 广度优先算法遍历二叉树
 *  本题听了视频，有使用队列解题思路，但还是没有写对
 *  处理层级时没有处理好，还需努力。。。
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 *
 * @author tangzhenhua
 * @date 2019/11/03 20:00
 */
public class LeetCode_102_076 {


    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> results = new ArrayList<>();

        if(root == null) return results;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int level = 0;

        while (!queue.isEmpty()) {

            results.add(new ArrayList<>());
            List list = results.get(level);
            int currLevel = queue.size();

            for(int i = 0; i < currLevel; i++) {

                TreeNode treeNode = queue.remove();
                list.add(treeNode.val);

                if(treeNode.left != null){
                    queue.add(treeNode.left);
                }

                if(treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }

            level++;

        }

        return results;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        TreeNode left2 = new TreeNode(15);
        TreeNode right2 = new TreeNode(7);

        root.left = left;
        root.right = right;

        right.left = left2;
        right.right = right2;

        LeetCode_102_076 leet = new LeetCode_102_076();
        List list = leet.levelOrder(root);
        System.out.println(list);
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}