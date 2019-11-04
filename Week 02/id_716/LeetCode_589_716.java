import java.util.ArrayList;
import java.util.List;

public class LeetCode_589_716 {

    // 1. 递归
    public List<Integer> preorder1(Node root) {
        List<Integer> res = new ArrayList<>();
        preorderTraversal(root, res);
        return res;
    }
    
    private void preorderTraversal(Node node, List<Integer> res) {
        // terminator
        if (node == null) return;
        
        // process current logic
        res.add(node.val);
        
        // terminator & drill down
        if (node.children != null) {
            for (Node child : node.children) {
                preorderTraversal(child, res);
            }
        }
        
        // restore current status
    }
    
    // 2. 非递归
    // 2.1
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        
        LinkedList<Node> stack = new LinkedList<>();
        stack.push(root);
        Node curr;
        while (!stack.isEmpty()) {
            curr = stack.pop();
            res.add(curr.val);
            
            // 压栈, 从右往左
            for (int i = curr.children.size() - 1; i >= 0; --i) {
                stack.push(curr.children.get(i));
            }
        }
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
