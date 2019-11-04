/**
 * Created by LynnSun on 2019/11/1.
 * 力扣题目地址：https://leetcode-cn.com/problems/jump-game-ii/
 */
public class JumpGameTwo {
    public int jump(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for(int i = 0; i < nums.length - 1; i++){
            // 找能跳的最远的
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if( i == end){ // 遇到边界，就更新边界，并且步数加一
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
