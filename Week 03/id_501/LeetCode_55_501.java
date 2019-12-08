package homework.week03;

/**
 * 55. 跳跃游戏
 * https://leetcode-cn.com/problems/jump-game/
 */
public class LeetCode_55_501{
    /**
     * 思路：
     * 从后往前遍历，当前索引 + 当前值 >= 最大索引，就把最大索引定义为当前索引，当前端索引为0，就到第一个元素了。
     * @param nums
     * @return
     */
    public static boolean canJump(int[] nums) {
        int lastIndex = nums.length - 1;
        for(int i = nums.length -1;i >=0; i--){
            if(i + nums[i] >= lastIndex){
                lastIndex = i;
            }
        }
        return lastIndex == 0;
    }
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{3,2,1,0,4}));
    }
}