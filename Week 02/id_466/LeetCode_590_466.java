//给定一个 N 叉树，返回其节点值的后序遍历。
//
// 例如，给定一个 3叉树 :
//
//
//
//
//
//
//
// 返回其后序遍历: [5,6,3,2,4,1].
//
//
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树
package com.aseara.leetcode.editor.cn.a590;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

/**
 * desc: 590.N叉树的后序遍历 <br />
 * Date: 2019/10/26 <br/>
 *
 * @author qiujingde
 */
class NAryTreePostorderTraversal {
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

        List<Integer> expected = Arrays.asList(5, 6, 3, 2, 4, 1);
        assertIterableEquals(expected, solution.postorder(root));
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
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> store = new LinkedList<>();
        traversal2(root, store);
        return store;
    }

    private void traversal(Node root, List<Integer> store) {
        if (root == null) {
            return;
        }
        if (root.children != null) {
            for (Node child : root.children) {
                traversal(child, store);
            }
        }
        store.add(root.val);
    }

    private void traversal2(Node root, LinkedList<Integer> store) {
        if (root == null) {
            return;
        }

        LinkedList<Node> stack = new LinkedList<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            store.addFirst(node.val);

            if (node.children != null) {
                for (Node child : node.children) {
                    stack.push(child);
                }
            }
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
