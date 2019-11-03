package Week2;

import java.util.*;

public class Leetcode_429 {
    public static void main(String[] args) {
        List<Node> list = new LinkedList<>();
        list.add(new Node(5,null));
        list.add(new Node(6,null));
        Node l1 = new Node(3,list);
        List<Node> list1 = new LinkedList<>();
        list1.add(l1);
        list1.add(new Node(2,null));
        list1.add(new Node(4,null));
        Node root = new Node(1,list1);

        List<List<Integer>> listans = levelOrder(root);
        for (List<Integer> li : listans ) {
            System.out.println(Arrays.toString(li.toArray()));
        }
    }

    /**
     * 简单模拟
     * 执行用时 :6 ms, 在所有 java 提交中击败了61.19%的用户
     * 内存消耗 :48.1 MB, 在所有 java 提交中击败了95.11%的用户
     * @param root
     * @return
     */
    private static List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> list = new LinkedList<>();
        if (root == null)
            return list;
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Queue<Node> help = new ArrayDeque<>();
            List<Integer> lis = new LinkedList<>();
            while (!queue.isEmpty()) {
                Node node = queue.remove();
                lis.add(node.val);
                if (node.children != null){
                    for (Node nod : node.children) {
                        help.add(nod);
                    }
                }
            }
            queue = help;
            list.add(lis);
        }
        return list;
    }
}
