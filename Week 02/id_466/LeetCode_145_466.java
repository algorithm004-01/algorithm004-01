//给定一个二叉树，返回它的 后序 遍历。
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
//输出: [3,2,1]
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树
package com.aseara.leetcode.editor.cn.a145;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

/**
 * desc: 145.二叉树的后序遍历 <br />
 * Date: 2019/10/24 <br/>
 *
 * @author qiujingde
 */
class BinaryTreePostorderTraversal {
    private Solution solution = new Solution();

    @Test
    void test1() {
        TreeNode root = new TreeNode(1);
        TreeNode child = new TreeNode(2);
        root.right = child;
        child.left = new TreeNode(3);

        List<Integer> expected = Arrays.asList(3, 2, 1);
        assertIterableEquals(expected, solution.postorderTraversal(root));
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
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> store = new LinkedList<>();
        traversal3(root, store);
        return store;
    }

    private void traversal(TreeNode root, List<Integer> store) {
        if (root == null) {
            return;
        }
        traversal(root.left, store);
        traversal(root.right, store);
        store.add(root.val);
    }

    private void traversal2(TreeNode root, List<Integer> store) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Boolean> direction = new LinkedList<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            while (node.left != null) {
                stack.push(node.left);
                direction.push(true);
                node = node.left;
            }

            boolean r = true;
            while (!r || node.right == null) {
                node = stack.pop();
                store.add(node.val);
                if (stack.isEmpty()) {
                    return;
                }
                node = stack.peek();
                r = direction.pop();
            }

            stack.push(node.right);
            direction.push(false);
        }
    }

    private void traversal3(TreeNode root, LinkedList<Integer> store) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            store.addFirst(node.val);

            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
    }

    private void traversal4(TreeNode root, LinkedList<Integer> store) {
        if (root == null) {
            return;
        }
        TreeNode cur = root;
        while (cur != null) {
            store.addFirst(cur.val);
            if (cur.right == null) {
                cur = cur.left;
                continue;
            }
            if (cur.left != null) {
                TreeNode pre = cur.right;
                while (pre.left != null) {
                    pre = pre.left;
                }
                pre.left = cur.left;
            }
            cur = cur.right;
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
                    stack.push(new Command(CommandCode.READ, node));
                    if (node.right != null) {
                        stack.push(new Command(CommandCode.TRAVERSAL, node.right));
                    }
                    if (node.left != null) {
                        stack.push(new Command(CommandCode.TRAVERSAL, node.left));
                    }
            }
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
