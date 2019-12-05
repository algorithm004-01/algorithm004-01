package sf.week5;

/**
 * Created by LynnSun on 2019/11/18.
 * 力扣题目地址：https://leetcode-cn.com/problems/maximum-product-subarray/
 *
 */
public class MaximumProductSubarray {
    /**
     * 顺着和最大的思路想的，但是还是借鉴了最优秀的解法
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] < 0){
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax*nums[i], nums[i]);
            imin = Math.min(imin*nums[i], nums[i]);

            max = Math.max(max, imax);
        }
        return max;
    }
}
