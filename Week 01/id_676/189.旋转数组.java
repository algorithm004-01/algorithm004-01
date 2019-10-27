
/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 旋转数组
 */

/*
*思路：1.暴力方法,k为几 就旋转几次数组  时间复杂度是O(n * k);
*2. 重开一个数组，将原数组中的值放在新数组下标为（i + k）% nums.length上，时间复杂度为O(n),空间复杂度为O(n);
*3.反转数组法，旋转链表k次，有k % nums.length个元素会移动到头部，剩下的会向后移动一个单位；时间复杂度为O(n)
*/

//暴力解法
class Solution {
    public void rotate(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int previous = nums[nums.length - 1];
            for (int j = 0; j  < nums.length; j++) {
                 int temp = nums[j];
                 nums[j] = previous;
                 previous = temp;
            }
        }
    }
}

//重开一个新的数组
class SolutionOne {
    public void rotate(int[] nums, int k) {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        System.arraycopy(a,0,nums,0,nums.length);
    }
}

//通过反转数组的方法进行旋转
class SolutionTwo {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reservse(nums,0,nums.length - 1); //反转整个数组
        reservse(nums, 0, k - 1); //反转前k个元素
        reservse(nums, k, nums.length - 1);  //反转后 n - k个元素
    }

    public void reservse (int nums[],int start, int end) {
        while (start < end) {   //由左右向中间逼近，成对交换两边的元素实现反转数组
            int temp = nums[start];
            nums[start] = nums[end];   
            nums[end] = temp;
            start++;
            end--;
        }
    }
}