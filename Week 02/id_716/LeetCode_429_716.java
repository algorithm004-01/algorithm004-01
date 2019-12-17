import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal
// n 叉树层次遍历

public class LeetCode_429_716 {
    // 1. loop + queue
    public List<List<Integer>> levelOrder1(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);
        Node curr;
        while (!queue.isEmpty()) {
            int levelCnt = queue.size();

            List<Integer> levelRes = new ArrayList<>();
            while (levelCnt-- > 0) {
                curr = queue.poll();
                levelRes.add(curr.val);
                for (Node child : curr.children) {
                    queue.offer(child);
                }
            }
            res.add(levelRes);
        }

        return res;
    }

    // 2. 递归
    public List<List<Integer>> levelOrder2(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        levelTraversal(root, 0, res);
        return res;
    }

    // 递归主要是找重复子问题：对于每个节点来讲都是先访问自己并加入结果列表，然后顺序从左到右访问子节点，这个就是最小的重复子问题
    private void levelTraversal(Node node, int level, List<List<Integer>> res) {
        // terminator
        if (node == null) return;

        // process current logic: 访问自己，记录节点的值
        if (level + 1 > res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(node.val);

        // drill down: 访问子节点
        for (Node child : node.children) {
            levelTraversal(child, level + 1, res);
        }

        // restore current status
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
