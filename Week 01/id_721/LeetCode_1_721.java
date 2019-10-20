package array;

/**
 * @author alis
 * @date 2019/10/20 3:58 PM
 * @description
 */
public class LC_01_TwoSum {

    /**
     * 暴力循环
     * O(n^2)
     * 中文网上使用哈希表的方式辅助判断有没有存在目标值的方式，说明时间复杂度是O(n),
     * 但是没考虑到哈希表对数据结构对处理，包括了扩容，排序，哈希计算等开销，如果从源码角度分析，这种算法恐怕比O(n^2)的时间复杂度更大
     */
    public int[] twoSumLoop(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }
}
