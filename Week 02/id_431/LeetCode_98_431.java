package medium;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author 潘磊明
 * @date 2019/10/23
 */
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
//        return traversal(root, null, null);
        return inOrder(root);
    }

//    /**
//     * 主要思想是每个节点都会在一个区间范围内，超出这个区间范围就不合法了
//     * @param node
//     * @param min
//     * @param max
//     * @return
//     */
//    public boolean traversal(TreeNode node, Integer min, Integer max){
//        if (node == null) return true;
//        if (min != null && node.val <= min) return false;
//        if (max != null && node.val >= max) return false;
//        if (!traversal(node.left, min, node.val)) return false;
//        if (!traversal(node.right, node.val, max)) return false;
//        return true;
//    }

    /**
     * 由于二叉搜索树的特性，对树进行中序遍历，那么该顺序就是从小到大的顺序
     * @param node
     * @return
     */
    public boolean inOrder(TreeNode node){
        Stack<TreeNode> stack = new Stack<>();
        Integer pre = null;
        while (node != null || !stack.isEmpty()) {
            //先按中顺遍历压栈
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (pre != null && pre >= node.val) return false;
            pre = node.val;
            node = node.right;
        }
        return true;
    }



    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
