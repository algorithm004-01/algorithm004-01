//给定一个二叉树，返回它的中序 遍历。
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
//输出: [1,3,2]
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树 哈希表
package com.aseara.leetcode.editor.cn.a94;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;


/**
 * desc: 94.二叉树的中序遍历 <br />
 * Date: 2019/10/23 <br/>
 *
 * @author qiujingde
 */
class BinaryTreeInorderTraversal {
    private Solution solution = new Solution();

    @Test
    void test1() {
        TreeNode root = new TreeNode(1);
        TreeNode child = new TreeNode(2);
        root.right = child;
        child.left = new TreeNode(3);

        List<Integer> expected = Arrays.asList(1, 3, 2);
        assertIterableEquals(expected, solution.inorderTraversal(root));
    }

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

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> store = new LinkedList<>();
        traversal5(root, store);
        return store;
    }

    private void traversal(TreeNode root, List<Integer> store) {
        if (root == null) {
            return;
        }
        traversal(root.left, store);
        store.add(root.val);
        traversal(root.right, store);
    }

    private void traversal2(TreeNode root, List<Integer> store) {
        if (root == null) {
            return;
        }

        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            while (node.left != null) {
                stack.push(node.left);
                node = node.left;
            }
            node = stack.pop();
            store.add(node.val);
            while (!stack.isEmpty() && node.right == null) {
                node = stack.pop();
                store.add(node.val);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
    }

    private void traversal3(TreeNode root, List<Integer> store) {
        LinkedList<TreeNode> stack = new LinkedList<>();

        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            store.add(cur.val);
            cur = cur.right;
        }
    }

    /**
     * 莫里斯循环
     * @param root   根节点
     * @param store  输出
     */
    private void traversal4(TreeNode root, List<Integer> store) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode mostRight = cur.left;
                while (mostRight.right != null) {
                    mostRight = mostRight.right;
                }

                mostRight.right = cur;
                cur = cur.left;
                mostRight.right.left = null;
            } else {
                store.add(cur.val);
                cur = cur.right;
            }
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
                    stack.push(new Command(CommandCode.READ, node));
                    if (node.left != null) {
                        stack.push(new Command(CommandCode.TRAVERSAL, node.left));
                    }
            }
        }
    }



}
//leetcode submit region end(Prohibit modification and deletion)
