/**
 * Created by LynnSun on 2019/11/1.
 * 力扣题目地址：https://leetcode-cn.com/problems/jump-game/
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            // 如果 数组索引 + 数组值>= 最后的索引值 才能意味着 可以跳到最后 如此 如果能找到第一个索引为正确
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}
