import java.util.*;
/**
 * N叉树的后序遍历
 */
public class Solution {
    /**
     * 多子节点后续遍历
     * 基于递归(1ms)
     */
    //使用全局变量
    List<Integer> list = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        if (root != null) {
            List<Node> children = root.children;
            for (Node node : children) {
                postorder(node);
            }
            list.add(root.val);
        }
        return list;
    }

    /**
     * 多子节点后续遍历
     * 基于递归(3ms)
     */
    public List<Integer> postorder2(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            List<Node> children = root.children;
            for (Node node : children) {
                list.addAll(postorder(node));
            }
            list.add(root.val);
        }
        return list;
    }

    /**
     * 多子节点后续遍历
     * 基于栈(6ms)
     */
    public List<Integer> postorder3(Node root) {
        Stack<Node> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        stack.push(root);
        while (!stack.isEmpty()) {
            Node head = stack.peek();
            if (head.children != null) {
                for (int i = head.children.size() - 1; i >= 0; i--) {
                    stack.push((head.children).get(i));
                }
                head.children = null;
            } else {
                list.add(head.val);
                stack.pop();
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