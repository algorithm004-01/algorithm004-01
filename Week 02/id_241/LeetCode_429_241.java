import java.util.*;
/**
 * N叉树的层序遍历
 */
public class Solution {
    /**
     * 多子节点层级遍历
     * 基于栈
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> l = new ArrayList<>();
        if (root == null) return l;
        helper(root, 0, l);
        return l;
    }

    private void helper(Node node, int deep, List<List<Integer>> res) {
        if (node == null) return;
        if (deep + 1 > res.size())
            res.add(new ArrayList<>());
        if (node.children != null)
            for (Node n : node.children) {
                helper(n, deep + 1, res);
            }
        res.get(deep).add(node.val);
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