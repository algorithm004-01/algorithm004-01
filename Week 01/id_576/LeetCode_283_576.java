/**
 * LeetCode_283_576
 */
public class LeetCode_283_576 {
    //1. 用j记录下一个非零位置,遇到非零元素就替换到将j位置上，再将i位置置为0，O(n)
    public void moveZeroes1(int[] nums) {
        //用j记录新加入元素位置的小操作，一定要熟记！
        int j = 0;//永远记录下一个非零位置
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (i != j) {
                    nums[i] = 0;
                }
                j++;
            }
        }

    }
    
    //2. 先把非零元素都移动到前面，在后面补0，O(n),参考国际站讨论区解法
    public void moveZeroes2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }//注意合理非法条件的判断，增加逻辑严谨性
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
               nums[j++] = nums[i];
            }
        }
        while (j < nums.length) {
            nums[j++] = 0;
        }
    }

    
}