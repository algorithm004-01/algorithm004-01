public class LeetCode_56_MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new LeetCode_56_MergeIntervals().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {

            if (intervals == null || intervals.length == 0) {
                return intervals;
            }
            List<int[]> res = new ArrayList<>();
            Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

            int i = 0;
            while (i < intervals.length) {
                int left = intervals[i][0];
                int right = intervals[i][1];
                while (i < intervals.length - 1 && right >= intervals[i + 1][0]) {
                    right = Math.max(right, intervals[i + 1][1]);
                    i++;
                }
                res.add(new int[]{left, right});
                i++;
            }
            return res.toArray(new int[0][]);
        }
    }

    class Solution1 {
        public int[][] merge(int[][] intervals) {

            if (intervals == null || intervals.length == 0) {
                return intervals;
            }
            List<int[]> res = new ArrayList<>();
            Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

            for (int i = 0; i < intervals.length; i++) {
                int left = intervals[i][0];
                int right = intervals[i][1];
                for (int j = i + 1; j < intervals.length; j++) {
                    if (right >= intervals[j][0]) {
                        // 前面区间的右区间包含了该区间的左区间
                        right = Math.max(right, intervals[j][1]);
                        i++;
                    } else {
                        break;
                    }
                }
                res.add(new int[]{left, right});
            }
            return res.toArray(new int[0][]);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}