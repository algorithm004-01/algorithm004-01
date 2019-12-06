import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-11-21 06:02
 **/

public class Leetcode_773_371 {
    public static void main(String[] args) {
        int[][] board = new int[][]{{1, 2, 3}, {4, 0, 5}};
        int step = slidingPuzzle(board);
        System.out.println("step = " + step);
    }
    /**
     * 仿解1: BFS
     *
     * @author Shaobo.Qian
     * @date 2019/11/21
     * @link https://leetcode.com/problems/sliding-puzzle/discuss/146652/Java-8ms-BFS-with-algorithm-explained
     */
    public static int slidingPuzzle(int[][] board) {
        String target = "123450";
        String start = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                start += board[i][j];
            }
        }
        //1.定义前进到下一步的方向(字符串中的索引位置<===二维坐标系)
        int[][] dirs = new int[][]{{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        Set<String> visited = new HashSet<>();
        visited.add(start);
        int step = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.remove();
                if (curr.equals(target)) return step;
                int zeroIndex = curr.indexOf('0');
                for (int nextIndex : dirs[zeroIndex]) {
                    String next = swap(zeroIndex, nextIndex, curr);
                    if (visited.contains(next)) continue;
                    queue.offer(next);
                    visited.add(next);
                }

            }
            step++;
        }
        return -1;
    }

    private static String swap(int i, int j, String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
    }
}
