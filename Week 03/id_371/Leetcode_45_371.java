/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-11-02 16:17
 **/

public class Leetcode_45_371 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        int jump = jump(nums);
        System.out.println("jump = " + jump);

    }

    /**
     * 仿解1:贪婪法(每次在可跳访问内,选择那个能调到更远的地方)
     * @author Shaobo.Qian
     * @date 2019/11/2
     * @link https://leetcode-cn.com/problems/jump-game-ii/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-10/
     */
    public static int jump(int[] nums) {
        int end = 0;
        int step = 0;
        int maxPosition = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (i == end) {//每次到达能边界的时候更新能跳跃到的边界和步数+1
                end = maxPosition;
                step++;
            }
        }
        return step;
    }
}
