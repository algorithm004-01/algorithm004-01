import java.util.*;
/**
 *乘积最大子序列
 */
public class Solution {
    public int maxProduct(int[] nums) {
        int imax = 1, imin = 1, max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax * num, num);
            imin = Math.min(imin * num, num);
            max = Math.max(max, imax);
        }
        return max;
    }
}