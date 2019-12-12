package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author alis
 * @date 2019/10/27 1:34 AM
 * @description
 */
public class LeetCode_590_721 {

    public List<Integer> postOrderRecur(NTreeNode root) {
        List<Integer> nums = new ArrayList<>();
        if (root == null) {
            return nums;
        }
        if (root.children != null && !root.children.isEmpty()) {
            for (NTreeNode child : root.children) {
                nums.addAll(postOrderRecur(child));
            }
        }
        nums.add(root.val);
        return nums;
    }


    /**
     * 利用栈实现后序遍历
     * 核心思想：确定栈的入栈顺序
     * 先将根结点栈，在判断子节点是否为空或者上一个输出节点是否为当前节点的子节点
     * 如果是，则输出本栈顶节点
     * 否则将本节点的子节点从右往左的顺序入栈
     */
    public List<Integer> postOrderStack(NTreeNode root) {
        List<Integer> nums = new ArrayList<>();
        Stack<NTreeNode> stack = new Stack<>();
        stack.push(root);
        NTreeNode lastNode = null;
        while (!stack.isEmpty()) {
            NTreeNode cur = stack.peek();
            if (cur.children.size() == 0 ||
                    (lastNode != null && cur.children.contains(lastNode))) {
                // 此为核心终结条件; 输出本节点的时候，判断子节点是否输出或者是否有子节点，
                // 如果没有子节点，可以直接输出自身
                // 如果有子节点，并且上一个输出不是自己的子节点，则需要先输出子节点，将子节点入栈
                // 自己第一做的时候，这一步没有控制好，导致漏了一些子节点
                nums.add(cur.val);
                stack.pop();
                lastNode = cur;
            } else {
                Collections.reverse(cur.children);
                cur.children.forEach(stack::push);
            }
        }
        return nums;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
