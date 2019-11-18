/**
 * LeetCode_198_576
 */
public class LeetCode_198_576 {

    /**
     * 使用二维数组存储每个房子偷或者不偷的值
     * 1. 标准写法
     * 
     */

    public int rob1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int[][] a = new int[n][2];

        a[0][0] = 0;
        a[0][1] = nums[0];

        for (int i = 1; i < n; ++i) {
            a[i][0] = Math.max(a[i-1][0], a[i-1][1]);
            a[i][1] = a[i-1][0] + nums[i];
        }
        return Math.max(a[n-1][0], a[n-1][1]);
    }

    /**
     * 2.进一步简化，将a[i]定义为0-i天，且nums[i]必偷的最大值
     */
    
    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int n = nums.length;
        int[] a = new int[n];

        a[0] = nums[0];
        a[1] = Math.max(nums[0], nums[1]);
        int res = Math.max(a[0], a[1]);
        for (int i = 2; i < n; ++i) {
            a[i] = Math.max(a[i-1], a[i-2] + nums[i]);
            res = Math.max(res, a[i]);
        }
        return res;

    }
    // 3. 更简化，只需要存贮3个变量就好
    public int rob3(int[] nums) {
        int prevMax = 0;
        int currMax = 0;
        for (int i : nums) {
            int temp = currMax;
            currMax = Math.max(prevMax + i, currMax);
            prevMax = temp;
        }
        return currMax;
    }

}