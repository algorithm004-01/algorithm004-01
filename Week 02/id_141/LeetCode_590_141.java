package app;

import java.util.ArrayList;
import java.util.List;

class NAryTree {
    public List<Integer> postorderTraversal(Node root) {
        List<Integer> res = new ArrayList<>();
        postorderHelper(root, res);
        return res;
    }
    private void postorderHelper(Node root, List<Integer> res){
        if (root != null) {
            if (root.children != null && root.children.size() > 0) {
                for (Node node : root.children) {
                    postorderHelper(node, res);
                }
            }
            res.add(root.val);
        }
    }
    public List<Integer> preorderTraversal(Node root) {
        List<Integer> res = new ArrayList<>();
        preorderHelper(root, res);
        return res;
    }
    private void preorderHelper(Node root, List<Integer> res) {
        if (root != null) {
            res.add(root.val);
            if (root.children != null && root.children.size() > 0) {
                for (Node node : root.children) {
                    preorderHelper(node, res);
                }
            }
        }
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
};