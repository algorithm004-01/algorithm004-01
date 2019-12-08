import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode_589_NAryTreePreorderTraversal {
    public static void main(String[] args) {
        Solution solution = new LeetCode_589_NAryTreePreorderTraversal().new Solution();
    }

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

            List<Integer> res = new ArrayList<>();
            if (root == null) return res;
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                root = stack.pop();
                res.add(root.val);
                if (root.children != null) {
                    for (int i = root.children.size() - 1; i >= 0; i--) {
                        stack.push(root.children.get(i));
                    }
                }
            }
            return res;
        }
    }

}