package com.leetcode.week02;

import com.leetcode.week02.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,3,2]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_94_416 {
    //1.递归
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        circleTreeNode(root, list);
        return list;
    }

    public void circleTreeNode(TreeNode node, List<Integer> list) {
        if (null != node) {
            if (null != node.left) {
                circleTreeNode(node.left, list);
            }
            //中序根在中间
            list.add(node.val);
            if (null != node.right) {
                circleTreeNode(node.right, list);
            }

        }
    }

    //2.stack的方法
    public List<Integer> inorderTraversal1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<Integer>();
        TreeNode treeNode = root;
        while (treeNode != null) {
            stack.push(treeNode);//把根节点和所有层的左节点都压入栈中
            treeNode = treeNode.left;
        }
        while (!stack.isEmpty()) {
            TreeNode tmp = stack.pop();//先把左节点弹出栈
            res.add(tmp.val);
            tmp = tmp.right;
            while (tmp != null) {
                stack.push(tmp);
                tmp = tmp.left;
            }
        }
        return res;
    }
}
