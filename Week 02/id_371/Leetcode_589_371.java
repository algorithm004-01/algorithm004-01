import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-10-26 16:02
 **/

public class Leetcode_589_371 {
    //定义 n叉树的数据结构
    class Node {
        int val;
        List<Node> children;

        public Node() {
        }

        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }


    /**
     * 原解2:使用栈模拟递归
     */
    public List<Integer> preorder2(Node root) {
        //边界条件
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        //递归出口
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            result.add(cur.val);
            List<Node> children = cur.children;
            if (children != null && children.size() != 0) {
                for (int i = children.size() - 1; i >= 0; i--) {
                    stack.push(children.get(i));
                }
            }
        }
        return result;
    }

    /**
     * 原解1:递归法
     */
    public List<Integer> preorder1(Node root) {
        List<Integer> result = new ArrayList<>();
        return recur(root, result);
    }

    private List<Integer> recur(Node root, List<Integer> result) {
        //1.递归出口
        if (root != null) {
            //2.处理当前层
            result.add(root.val);
            List<Node> children = root.children;
            if (children != null && children.size() != 0) {
                for (Node child : children) {
                    //3.带上参数,去下一层
                    recur(child, result);
                }
            }
        }
        //4.清理当前层
        return result;
    }

}
