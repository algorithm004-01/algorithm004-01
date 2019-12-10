//给定一个 N 叉树，返回其节点值的前序遍历。
//
// 例如，给定一个 3叉树 :
//
//
//
//
//
//
//
// 返回其前序遍历: [1,3,5,6,2,4]。
//
//
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树
package com.aseara.leetcode.editor.cn.a589;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

/**
 * desc: 589.N叉树的前序遍历 <br />
 * Date: 2019/10/27 <br/>
 *
 * @author qiujingde
 */
class NAryTreePreorderTraversal {
    private Solution solution = new Solution();

    @Test
    void test1() {
        Node root = new Node(1, new LinkedList<>());

        Node child = new Node(3, new LinkedList<>());
        child.children.add(new Node(5, null));
        child.children.add(new Node(6, null));

        root.children.add(child);
        root.children.add(new Node(2, null));
        root.children.add(new Node(4, null));

        List<Integer> expected = Arrays.asList(1, 3, 5, 6, 2, 4);
        assertIterableEquals(expected, solution.preorder(root));
    }

}


//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

class Solution {
    public List<Integer> preorder(Node root) {
        LinkedList<Integer> store = new LinkedList<>();
        traversal4(root, store);
        return store;
    }

    /**
     * 递归
     */
    private void traversal(Node node, List<Integer> store) {
        if (node == null) {
            return;
        }
        store.add(node.val);
        if (node.children != null && !node.children.isEmpty()) {
            for (Node child : node.children) {
                traversal(child, store);
            }
        }
    }

    /**
     * 迭代
     */
    private void traversal2(Node root, List<Integer> store) {
        if (root == null) {
            return;
        }

        LinkedList<Node> stack = new LinkedList<>();
        stack.push(root);

        LinkedList<Node> childDeque = new LinkedList<>();

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            store.add(node.val);

            if (node.children != null && !node.children.isEmpty()) {
                childDeque.addAll(node.children);
                while (!childDeque.isEmpty()) {
                    Node child = childDeque.pollLast();
                    if (child != null) {
                        stack.push(child);
                    }
                }
            }
        }
    }

    /**
     * 回溯
     */
    private void traversal3(Node root, List<Integer> store) {
        if (root == null) {
            return;
        }

        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> childIndexStack = new LinkedList<>();

        stack.push(root);
        childIndexStack.push(0);

        while (!stack.isEmpty()) {
            Node node = stack.peek();
            int childIndex = childIndexStack.pop();

            if (node == null) {
                stack.pop();
                childIndexStack.push(childIndex + 1);
                continue;
            }

            int childrenSize = node.children == null ? 0 : node.children.size();

            // 该节点第一次放入，存值
            if (childIndex == 0) {
                store.add(node.val);
            }

            // 该节点的所有子节点处理完成，弹出
            if (childIndex == childrenSize) {
                stack.pop();
                continue;
            }

            Node nextChild = node.children.get(childIndex);
            childIndexStack.push(childIndex + 1);
            childIndexStack.push(0);
            stack.push(nextChild);
        }
    }

    /**
     * 回溯2
     */
    private void traversal4(Node root, List<Integer> store) {
        if (root == null) {
            return;
        }

        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> childIndexStack = new LinkedList<>();

        stack.push(root);
        store.add(root.val);
        childIndexStack.push(0);

        while (!stack.isEmpty()) {
            Node node = stack.peek();
            int childIndex = childIndexStack.pop();
            if (node.children == null || node.children.isEmpty()) {
                stack.pop();
                continue;
            }
            // next not null node
            Node nextChild = null;
            for (; childIndex < node.children.size() && nextChild == null; childIndex++) {
                nextChild = node.children.get(childIndex);
            }
            // 压入下一个 child
            if (nextChild != null) {
                childIndexStack.push(childIndex);
                stack.push(nextChild);
                store.add(nextChild.val);
                childIndexStack.push(0);
                // child 处理完成，弹出当前节点
            } else {
                stack.pop();
            }
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
