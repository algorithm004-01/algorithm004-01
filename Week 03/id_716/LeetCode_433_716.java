import java.util.LinkedList;
import java.util.Queue;

// https://leetcode-cn.com/problems/minimum-genetic-mutation
// 最小基因变化

public class LeetCode_433_716 {
    // 1. 0ms (100%), 33.8M (68.18%)
    public int minMutation(String start, String end, String[] bank) {
        if (start.equals(end)) return 0;

        // bfs
        int level = 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        boolean[] visited = new boolean[bank.length];

        while (!queue.isEmpty()) {
            int currSize = queue.size();
            while (currSize-- > 0) {
                String curr = queue.poll();
                if (curr.equals(end)) return level;

                for (int i = 0; i < bank.length; i++) {
                    if (!visited[i] && isValid(curr, bank[i])) {
                        visited[i] = true;
                        queue.offer(bank[i]);
                    }
                }
            }
            level++;
        }
        
        return -1;
    }

    private boolean isValid(String seq1, String seq2) {
        int diffCnt = 0;
        for (int i = 0; i < seq1.length(); i++) {
            if (seq1.charAt(i) != seq2.charAt(i)) {
                diffCnt++;
                if (diffCnt > 1) {
                    return false;
                }
            }
        }
        return diffCnt == 1;
    }
}