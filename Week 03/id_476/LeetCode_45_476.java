public class LeetCode_45_JumpGameIi {
    public static void main(String[] args) {
        Solution solution = new LeetCode_45_JumpGameIi().new Solution();
    }


    class Solution {
        public int jump(int[] nums) {

            int steps = 0;
            // 当前点能到达的最远距离
            int curEnd = 0;
            // 当前点能到达的范围内的点能到达的最远距离
            int curFarthest = 0;
            // 贪心算法，每次跳到当前点能到达的范围内能跳最远距离的点
            for (int i = 0; i < nums.length - 1; i++) {
                curFarthest = Math.max(curFarthest, nums[i] + i);
                if (curEnd == i) {
                    steps++;
                    curEnd = curFarthest;
                }
            }
            return steps;
        }
    }

}