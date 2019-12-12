import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by LynnSun on 2019/10/26.
 */
public class Tree_LevelOrder {


    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        helper(root, 0, res);
        return res;
    }

    /**
     * 递归方式层序遍历
     * @param root
     * @param depth
     * @param res
     */
    private void helper(Node root, int depth, List<List<Integer>> res) {
        if (root == null) return;
        if (depth + 1 > res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(depth).add(root.val);
        for (Node node : root.children) {
            if (node != null) {
                helper(node, depth + 1, res);
            }
        }
    }

    /**
     * 队列方式
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder_Queue(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<Node>();
        if (root != null) {
            queue.offer(root);
            while(!queue.isEmpty()) {
                List<Integer> list = new ArrayList<>();
                int count = queue.size();
                for(int i = 0; i < count; i++) {
                    Node cur = queue.poll();
                    for(Node node : cur.children) {
                        queue.add(node);
                    }
                    list.add(cur.val);
                }
                result.add(list);
            }
        }
        return result;
    }

}
