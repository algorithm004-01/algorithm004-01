/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-11-12 18:52
 **/

public class Leetcode_152_371 {
    public static void main(String[] args) {

//        int[] nums = {2, 3, -2, 4};//2,3 ==>6
        int[] nums = {-2, 0, -1, 3, 4, -2, -5, -8, -3, -3, 10};//2,3 ==>6
        int ans = maxProduct1(nums);
        System.out.println("ans = " + ans);
    }

    /**
     * 仿解1:dp
     *
     * @author Shaobo.Qian
     * @date 2019/11/17
     * @link https://leetcode-cn.com/problems/maximum-product-subarray/solution/hua-jie-suan-fa-152-cheng-ji-zui-da-zi-xu-lie-by-g/
     */
    public static int maxProduct1(int[] nums) {
        //1.确定需要维护的状态
        //1.1哪个节点作为终点的最大连续子乘积最大?
        int max = Integer.MIN_VALUE;
        //1.2当前节点为终点的最大连续子乘积
        int currMax = 1;
        //1.3当前节点为终点的最小连续子乘积
        int currMin = 1;
        //2.dp 方程(循环+记忆化)
        for (int num : nums) {
            if (num < 0) {
                int temp = currMax;
                currMax = currMin;
                currMin = temp;
            }
            //3.子问题的解
            currMax = Math.max(num, currMax * num);
            currMin = Math.min(num, currMin * num);
            max = Math.max(max, currMax);
        }

        return max;
    }

    /**
     * 原解1:dp(未解出)
     *
     * @author Shaobo.Qian
     * @date 2019/11/12
     */
    public static int maxProduct(int[] nums) {

        int maxEndHere = nums[0];
        int maxSoFar = nums[0];
        for (int i = 1; i < nums.length; i++) {

            //最优子结构
            if (maxEndHere >= 0 && nums[i] < 0) {
                if (i < nums.length - 1 && nums[i + 1] < 0) {
                    maxEndHere = maxEndHere * nums[i] * nums[i + 1];
                    i++;
                } else {
                    maxEndHere = nums[i];
                }
            } else {
                maxEndHere = Math.max(nums[i], maxEndHere * nums[i]);
            }
//            maxEndHere = Math.max(nums[i], maxEndHere * nums[i]);
            //状态转移方程
            maxSoFar = Math.max(maxSoFar, maxEndHere);
        }

        return maxSoFar;
    }
}
