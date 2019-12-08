import java.util.*;
/**
 *  N叉树的前序遍历
 */
public class Solution {
    /**
     * 多子节点前续遍历
     * 基于递归(1ms)
     */
    public List<Integer> preorder(Node root) {
        if (root != null) {
            list.add(root.val);
            if (root.children != null)
                for (int i = 0; i < root.children.size(); i++) {
                    preorder(root.children.get(i));
                }
        }
        return list;
    }

    /**
     * 多子节点前续遍历
     * 基于栈(5ms)
     */
    public List<Integer> preorder2(Node root) {
        Stack<Node> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        stack.push(root);
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            list.add(curr.val);
            if (curr.children != null) {
                for (int i = curr.children.size() - 1; i >= 0; i--) {
                    stack.push(curr.children.get(i));
                }
            }
        }
        return list;
    }

    class Node {
        int val;
        List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}