/**
 * @author tangzhenhua
 * @description
 * @date 2019/10/27 22:30
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


public class LeetCode_94_076 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        tra(list, root);
        return list;
    }


    public void tra(List<Integer> list, TreeNode root){

        if(root == null) {
            return;
        }

        if(root.left!=null){
            tra(list, root.left);
        }

        list.add(root.val);

        if(root.right != null){
            tra(list, root.right);
        }

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode right1 = new TreeNode(2);
        TreeNode left2 = new TreeNode(3);

        right1.left = left2;
        root.right = right1;

        LeetCode_94_076 leet = new LeetCode_94_076();

        List<Integer> list = leet.inorderTraversal(root);
        System.out.println(list);
    }
}
