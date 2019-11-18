/**
 * LeetCode_55_576
 */
public class LeetCode_55_576 {
    //1. 贪心算法思路o（n）
    public boolean canJump(int[] nums) {
        if (nums == null) {
            return false;
        }
        int endReachable = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] + i >= endReachable) {
                endReachable = i;
            }
        }
        return endReachable == 0;
    }
}