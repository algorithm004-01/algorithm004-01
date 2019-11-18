import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode-cn.com/problems/generate-parentheses
// 括号生成

public class LeetCode_22_716 {
    // 1. dfs 的思想
    public List<String> generateParenthesis1(int n) {
        List<String> res = new ArrayList<>();
        dfs("", 0, 0, n, res);
        return res;
    }

    private void dfs(String s, int left, int right, int n, List<String> res) {
        // terminator
        if (left == n && right == n) {
            res.add(s);
            return;
        }

        // process current logic: add left or add right
        // dirll down
        if (left < n) dfs(s + "(", left + 1, right, n, res);
        if (left > right) dfs(s + ")", left, right + 1, n, res);
    }

    // 2. bfs 的思想
    public List<String> generateParenthesis2(int n) {
        List<String> res = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node("", 0, 0));

        int level = 2 * n;
        while (level > 0) {
            int size = queue.size();
            while (size-- > 0) {
                Node curr = queue.poll();
                if (curr.l < n) queue.offer(new Node(curr.s + "(", curr.l + 1, curr.r));
                if (curr.l > curr.r) queue.offer(new Node(curr.s + ")", curr.l, curr.r + 1));
            }
            level--;
        }

        while (!queue.isEmpty()) {
            res.add(queue.poll().s);
        }

        return res;
    }

    class Node {
        String s;
        int l;  // left
        int r;  // right
        Node(String s, int left, int right) {
            this.s = s;
            l = left;
            r = right;
        }
    }
}