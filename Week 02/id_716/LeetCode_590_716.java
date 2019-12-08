import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

// https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal
// n叉树后续遍历

public class LeetCode_590_716 {
    // 1. 递归遍历
    public List<Integer> postorder1(Node root) {
        List<Integer> res = new ArrayList<>();
        postorderTraversal(root, res);
        return res;
    }

    private void postorderTraversal(Node node, List<Integer> res) {
        // terminator
        if (node == null) return;

        // drill down
        if (node.children != null) {
            for (Node child : node.children) {
                postorderTraversal(child, res);
            }
        }
        // process current logic
        res.add(node.val);
    }

    // 2. 非递归，loop + stack
    // 2.1 记录访问过子节点的父节点，防止重复访问
    public List<Integer> postorder21(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Set<Node> childVisited = new HashSet<>();
        LinkedList<Node> stack = new LinkedList<>();
        stack.push(root);
        Node curr;
        while (!stack.isEmpty()) {
            curr = stack.peek();
            // 压栈
            if (curr.children.size() > 0 && !childVisited.contains(curr)) {
                for (int i = curr.children.size() - 1; i >= 0; --i) {
                    stack.push(curr.children.get(i));
                }
                childVisited.add(curr);
            } else {
                res.add(curr.val);
                stack.pop();
            }
        }
        return res;
    }

    // 2.2 使用 pre 指针来判断子节点是否已经被访问过
    public List<Integer> postorder22(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        LinkedList<Node> stack = new LinkedList<>();
        stack.push(root);
        Node pre = null, curr = null;
        while (!stack.isEmpty()) {
            curr = stack.peek();
            // 如果节点的孩子数量为0或者已经访问过子节点，从栈中弹出后直接添加结果集，不需要再重复压栈了
            if (curr.children.size() == 0 || (pre != null && !curr.children.contains(pre))) {
                // 添加结果集
                res.add(curr.val);
                stack.pop();
                // 记录上一次访问的节点
                pre = curr;
            } else {
                // 压栈, 从右往左压
                for (int i = curr.children.size() - 1; i >= 0; --i) {
                    stack.push(curr.children.get(i));
                }
            }
        }
        return res;
    }

    // 2.3 利用后序遍历的逆序，然后反转结果
    public List<Integer> postorder23(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        LinkedList<Node> stack = new LinkedList<>();
        stack.push(root);
        Node curr;
        while (!stack.isEmpty()) {
            curr = stack.pop();
            // 逆序添加元素
            res.add(curr.val);
            // 从做往右压栈，弹出的时候就是从右往左了
            for (Node child : curr.children) {
                stack.push(child);
            }
        }
        // 将结果反转就是后序遍历的顺序了
        Collections.reverse(res);
        return res;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
} 