import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-11-28 03:39
 **/

public class Leetcode_56_371 {
    public static void main(String[] args) {
        //[[1,3],[2,6],[8,10],[15,18]] ==>[[1,6],[8,10],[15,18]]
//        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] intervals = {{1, 4}, {0, 4}};
        int[][] res = merge(intervals);
        for (int i = 0; i < res.length; i++) {
            Arrays.stream(res[i]).forEach(System.out::println);
        }

    }

    /**
     * 原解1:降维度+排序
     *
     * @author Shaobo.Qian
     * @date 2019/11/28
     */
    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;
        //1.根据二维数组第一个数字大小按每一行整体排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(intervals[0][0]);
        deque.addLast(intervals[0][1]);
        //1.降维度
        for (int i = 1; i < intervals.length; i++) {

            int[] interval = intervals[i];
            Integer min = deque.getFirst();
            Integer max = deque.getLast();
            if (interval[1] > max && interval[0] < min) {
                deque = new LinkedList<>();
                deque.addFirst(interval[0]);
                deque.addLast(interval[1]);
            } else if (interval[1] < min) {
                deque.addFirst(interval[1]);
                deque.addFirst(interval[0]);
            } else if (interval[0] > max) {
                deque.addLast(interval[0]);
                deque.addLast(interval[1]);
            } else if (interval[1] > max) {
                deque.removeLast();
                deque.addLast(interval[1]);
            } else if (interval[0] < min) {
                deque.removeFirst();
                deque.addFirst(interval[0]);
            }

        }
        //2.返回结果

        return

                transferArr(deque);

    }

    private static int[][] transferArr(Deque<Integer> deque) {
        int size = deque.size();
        int[][] res = new int[size / 2][2];
        for (int i = 0; i < size / 2; i++) {
            res[i][0] = (int) deque.pollFirst();
            res[i][1] = (int) deque.pollFirst();
        }
        return res;
    }
}
