import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode_590_NAryTreePostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new LeetCode_590_NAryTreePostorderTraversal().new Solution();
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
        public List<Integer> postorder(Node root) {
            // 迭代
            List<Integer> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                root = stack.pop();
                res.add(0, root.val);
                for (Node node : root.children) {
                    stack.push(node);
                }
            }
            return res;
        }
    }

}