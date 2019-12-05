package homework.week01;

import java.util.Arrays;

/**
 * 189. 旋转数组
 * https://leetcode-cn.com/problems/rotate-array/
 */
public class RotateArray{

    /**
     * 暴力法
     * 思路：先写出来每次移动一位的方法，首尾互换，然后再根据k遍历，然后移动k次即可。
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        for (int j = 0;j < k;j++){
            int temp; 
            int end = nums[nums.length - 1];
            for(int i = 0;i < nums.length;i++){
                temp = end;
                end = nums[i];
                nums[i] = temp;
            }
        }
    }

    /**
     * 反转法
     * 参考链接：https://leetcode-cn.com/problems/rotate-array/solution/xuan-zhuan-shu-zu-by-leetcode/
     * 旋转数组k次，k%n个尾部元素会被移动到头部，剩余的元素会向后移动
     * 首先把所有元素反转，然后反转前k个，然后再反转后面n-k个，则得到结果
     * @param nums
     * @param k
     */
    public static void rotate2(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k -1);
        reverse(nums, k, nums.length - 1);
    }

    /**
     * 反转
     * @param nums
     * @param start
     * @param end
     */
    public static void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start ++;
            end -- ;
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        // rotate(nums,3);
        rotate2(nums,3);
        System.out.println(Arrays.toString(nums));
    }
}