/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-11-12 18:19
 **/

public class Leetcode_53_371 {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};//4,-1,2,1 ==>6
        int ans = maxSubArray2(nums);
        System.out.println("ans = " + ans);
    }

    /**
     * 仿解2:dp(更清楚的解释了dp的结构)
     * @author Shaobo.Qian
     * @date 2019/11/12
     * @link https://leetcode-cn.com/problems/maximum-subarray/solution/xiang-xi-jie-du-dong-tai-gui-hua-de-shi-xian-yi-li/
     */
    public static int maxSubArray2(int[] nums) {
        int maxEndHere = nums[0];
        int maxSoFar = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //最佳子结构
            maxEndHere = Math.max(nums[i], maxEndHere + nums[i]);
            //状态转移方程
            maxSoFar = Math.max(maxEndHere, maxSoFar);
        }
        return maxSoFar;
    }
    /**
     * 仿解1:动态规划
     * @author Shaobo.Qian
     * @date 2019/11/12
     * @link https://leetcode-cn.com/problems/maximum-subarray/solution/hua-jie-suan-fa-53-zui-da-zi-xu-he-by-guanpengchn/
     */
    public static int maxSubArray1(int[] nums) {
        int ans = 0;//结果
        int sumed = 0;//当前最大子序列和
        for (int i = 0; i < nums.length; i++) {
            if (sumed > 0) { // sumed>0对结果有增益,保留
                sumed += nums[i];
            } else {
                sumed = nums[i]; //sumed<0对结果无增益,舍弃
            }
        }
        ans = Math.max(ans, sumed);
        return ans;
    }
}
