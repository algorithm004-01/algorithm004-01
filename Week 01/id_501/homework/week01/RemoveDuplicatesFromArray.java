package homework.week01;

import java.util.Arrays;

/**
 * 26. 删除排序数组中的重复项
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 */
public class RemoveDuplicatesFromArray{
    /**
     * 思路：
     * i 和 j 比较，j 比 1索引大1，判断是否相等，如果相等，就比较i和j+1，依次类推，直到i和j + n不相等，
     * 就把 i + 1，换成 j + n的值。本次替换结束，下一次，i + 1,继续和j+n+1的值比较。直到j = nums.length -1
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 1;
        while(j < nums.length){
            if(nums[i] != nums[j]){
                nums[i + 1] = nums[j];
                i ++ ;
            }
            j ++ ;
            System.out.println("i,j = " + i + "," + j +" " + Arrays.toString(nums));
        }
        return i + 1 ;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        int count = removeDuplicates(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(count);
    }
}