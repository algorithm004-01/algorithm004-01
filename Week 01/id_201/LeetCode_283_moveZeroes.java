//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     * 时间复杂度 O(N)
     * 双指针， I 指针遍历所有元素， J指针代表0元素的开始位置 （下一个非零元素放置位置）
     * 交换零元素和非零元素的值
     * （该交换是对于下一个补全0元素方法的优化  EXAMPL： [0 , 0 , 0, 1] 在该场景下只需要交换一次，而下一种方法需要操作N次）
     * 一个简单的实现是，如果当前元素是非 0 的，那么它的正确位置最多可以是当前位置或者更早的位置。如果是后者，则当前位置最终将被非 0 或 0 占据，该非 0 或 0 位于大于 “cur” 索引的索引处。我们马上用 0 填充当前位置，这样不像以前的解决方案，我们不需要在下一个迭代中回到这里。
     *
     * 换句话说，代码将保持以下不变：
     *
     * 慢指针（lastnonzerofoundat）之前的所有元素都是非零的。
     * 当前指针和慢速指针之间的所有元素都是零。
     * 因此，当我们遇到一个非零元素时，我们需要交换当前指针和慢速指针指向的元素，然后前进两个指针。如果它是零元素，我们只前进当前指针。
     *
     * 链接：https://leetcode-cn.com/problems/move-zeroes/solution/yi-dong-ling-by-leetcode/
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
                if (i != j++)
                    nums[i] = 0;
            }
        }
    }


    /**
     * 时间复杂度 O(N)
     * @param nums
     */
    public void moveZeroes1(int[] nums) {
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        while (j < nums.length) {
            nums[j++] = 0;
        }
    }

    /**
     * snowball
     * https://leetcode.com/problems/move-zeroes/discuss/172432/THE-EASIEST-but-UNUSUAL-snowball-JAVA-solution-BEATS-100-(O(n))-%2B-clear-explanation
     * @param nums
     */
    public void moveZeroes2 (int[] nums) {
        public void moveZeroes(int[] nums) {
            int snowBallSize = 0;
            for (int i=0;i<nums.length;i++){
                if (nums[i]==0){
                    snowBallSize++;
                }
                else if (snowBallSize > 0) {
                    int t = nums[i];
                    nums[i]=0;
                    nums[i-snowBallSize]=t;
                }
            }
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
