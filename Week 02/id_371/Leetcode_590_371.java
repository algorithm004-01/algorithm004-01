import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-10-26 13:35
 **/

public class Leetcode_590_371 {

    class Node {
        private int val;
        List<Node> children;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }

    /**
     * 原解2:使用栈模拟递归
     *
     * @param root
     * @return
     */
    public List<Integer> postorder2(Node root) {
        //0.边界处理
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        //定义前指针(用来保证让父节点正确的弹出)
        Node pre = null;
        //1.递归出口条件
        while (!stack.isEmpty()) {
            Node cur = stack.peek();
            List<Node> children = cur.children;
            if (children.size() == 0 || cur.children.contains(pre)) {
                result.add(cur.val);
                stack.pop();
                pre = cur;
            } else {
                //将子节点压入栈
                for (int i = children.size() - 1; i >= 0; i--) {
                    stack.push(children.get(i));
                }
            }
        }
        return result;
    }

    /**
     * 原解1:递归
     *
     * @param root
     * @return
     */
    public List<Integer> postorder1(Node root) {
        List<Integer> result = new ArrayList<>();
        return recur(root, result);
    }


    private List<Integer> recur(Node node, List<Integer> result) {
        //1.递归出口
        if (node != null) {
            //2.处理当前层
            List<Node> children = node.children;
            if (children != null && children.size() > 0) {
                for (Node child : children) {
                    //3.进入下一层
                    recur(child, result);
                }
            }
            result.add(node.val);
        }
        //4.清理当前层

        return result;
    }
}
