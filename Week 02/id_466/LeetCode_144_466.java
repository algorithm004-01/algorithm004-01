//给定一个二叉树，返回它的 前序 遍历。
//
// 示例:
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,2,3]
//
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树
package com.aseara.leetcode.editor.cn.a144;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

/**
 * desc: 144.二叉树的前序遍历 <br />
 * Date: 2019/10/24 <br/>
 *
 * @author qiujingde
 */
class BinaryTreePreorderTraversal {
    private Solution solution = new Solution();

    @Test
    void test1() {
        TreeNode root = new TreeNode(1);
        TreeNode child = new TreeNode(2);
        root.right = child;
        child.left = new TreeNode(3);

        List<Integer> expected = Arrays.asList(1, 2, 3);
        assertIterableEquals(expected, solution.preorderTraversal(root));
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

//leetcode submit region begin(Prohibit modification and deletion)
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
        List<Integer> store = new LinkedList<>();
        traversal5(root, store);
        return store;
    }

    private void traversal(TreeNode root, List<Integer> store) {
        if (root == null) {
            return;
        }
        store.add(root.val);
        traversal(root.left, store);
        traversal(root.right, store);
    }

    private void traversal2(TreeNode root, List<Integer> store) {
        if (root == null) {
            return;
        }

        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        store.add(root.val);

        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            while (node.left != null) {
                stack.push(node.left);
                store.add(node.left.val);
                node = node.left;
            }

            node = stack.pop();
            while (!stack.isEmpty() && node.right == null) {
                node = stack.pop();
            }

            if (node.right != null) {
                stack.push(node.right);
                store.add(node.right.val);
            }
        }

    }

    private void traversal3(TreeNode root, List<Integer> store) {
        if (root == null) {
            return;
        }

        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            store.add(cur.val);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    private void traversal4(TreeNode root, List<Integer> store) {
        if (root == null) {
            return;
        }
        TreeNode cur = root;

        while (cur != null) {
            store.add(cur.val);
            if (cur.left == null) {
                cur = cur.right;
                continue;
            }
            if (cur.right != null) {
                TreeNode pre = cur.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = cur.right;
            }
            cur = cur.left;
        }
    }

    private enum CommandCode {
        READ, TRAVERSAL
    }

    private static class Command {
        CommandCode code;
        TreeNode node;
        Command(CommandCode code, TreeNode node) {
            this.code = code;
            this.node = node;
        }
    }

    private void traversal5(TreeNode root, List<Integer> store) {
        if (root == null) {
            return;
        }
        LinkedList<Command> stack = new LinkedList<>();
        stack.push(new Command(CommandCode.TRAVERSAL, root));
        while (!stack.isEmpty()) {
            Command command = stack.pop();
            TreeNode node = command.node;
            switch (command.code) {
                case READ:
                    store.add(node.val);
                    break;
                case TRAVERSAL:
                    if (node.right != null) {
                        stack.push(new Command(CommandCode.TRAVERSAL, node.right));
                    }
                    if (node.left != null) {
                        stack.push(new Command(CommandCode.TRAVERSAL, node.left));
                    }
                    stack.push(new Command(CommandCode.READ, node));
            }
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
