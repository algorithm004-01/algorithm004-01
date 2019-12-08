import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-10-26 16:23
 **/

public class Leetcode_429_371 {
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
     * 仿解2: 递归
     */
    public List<List<Integer>> levelOrder3(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        recur1(root, 0, result);
        return result;
    }

    private void recur1(Node root, int level, List<List<Integer>> result) {
        //1.递归出口
        if (root == null) return;
        //2.处理当前层(判断是否是新的一层--->因为是在循环里递归)
        if (level + 1 > result.size()) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        List<Node> children = root.children;
        for (Node child : children) {
            if (child != null) {
                //3.带上参数,去下一次
                recur1(child, level + 1, result);
            }
        }

        //4.清理当前层
    }

    /**
     * 仿解1:遍历法-->通过队列模拟广度优先搜索
     */
    public List<List<Integer>> levelOrder2(Node root) {
        //处理边界
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            //外层每循环一次为一度关系
            int count = queue.size();
            List<Integer> list = new ArrayList<>();
            while (count-- > 0) {
                Node cur = queue.poll();
                list.add(cur.val);
                List<Node> children = cur.children;
                if (children != null && children.size() > 0) {
                    for (Node child : children) {
                        if (child != null) {
                            queue.add(child);
                        }
                    }
                }
            }
            result.add(list);
        }
        return result;
    }

    /**
     * 原解1:广度优先搜素 (未解出)
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder1(Node root) {
        List<List<Integer>> result = new ArrayList<>();

        return recur(root, result);
    }

    private List<List<Integer>> recur(Node root, List<List<Integer>> result) {
        Queue<Node> queue = new LinkedBlockingQueue();
        List<Integer> level1 = new ArrayList<>();
        level1.add(root.val);
        //1.递归出口
        while (!queue.isEmpty()) {
            //2.处理当前层
            List<Node> children = root.children;
            for (Node child : children) {
                queue.add(child);
            }
//            queue.add()
            Node cur = queue.poll();

        }

        return null;
    }

}
