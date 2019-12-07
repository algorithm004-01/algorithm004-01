package Week5;

public class Leetcode_198_711 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(rob1(nums));
    }

    /**
     * 题解做法。。
     * 执行用时 :0 ms, 在所有 java 提交中击败了100.00%的用户
     * 内存消耗 :33.9 MB, 在所有 java 提交中击败了90.38%的用户
     * @param nums
     * @return
     */
    private static int rob1(int[] nums) {
        int preMax = 0;
        int curMax = 0; //巧妙地解决了1，2的处理
        for (int x : nums) {
            int temp = curMax;
            curMax = Math.max(x + preMax,curMax);
            preMax = temp;
        }
        return curMax;
    }

    /**
     * f[i] = Math.max(f[i - 2] + nums[i], f[i - 1]);
     * 执行用时 :0 ms, 在所有 java 提交中击败了100.00%的用户
     * 内存消耗 :34 MB, 在所有 java 提交中击败了90.38%的用户
     * @param nums
     * @return
     */
    private static int rob(int[] nums) {
        int n = nums.length;
        if (n < 1)
            return 0;
        if (n < 2)
            return nums[0];
        nums[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < n; i++) {
            nums[i] = Math.max(nums[i - 2] + nums[i], nums[i - 1]);
        }
        return nums[n - 1];
    }
}
