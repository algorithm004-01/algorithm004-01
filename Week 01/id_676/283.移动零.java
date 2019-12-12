/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

 /*
 *思路：1.暴力,循环整个数组，找到所有0, 时间复杂度为O(n)
 *2.再开一个新数组
 *3.在原数组的基础上操作index (通过引入一个新的变量j,操作非0值的数组下标)
 *4.采用滚雪球的方法进行操作
 */

 //暴力解法
class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0;i<nums.length;++i) {
            if  (nums[i] != 0) {
                nums[j] = nums[i];
                if  (i != j) {
                    nums[i] = 0;
                }
                j++;
            }
        }
    }
}

//遍历数组找到数组中所有非0的值然后顺序放到数组最前面，然后将后面的值全部置0
class SolutionOne {
    public void moveZeroes(int[] nums) {
        if (nums == null  || nums.length  == 0)  return;
        int j = 0;
        for (int num : nums) {
            if (num != 0) nums[j++] = num;
        } 
        while (j < nums.length) {
            nums[j++] = 0;
        }
    }
}

// 不断地将0和非0的值进行交换
class SolutionTwo {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
    }
}

//滚雪球算法
class SolutionThree {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0;i < nums.length;++i) {
            if (nums[i] == 0) {
                j++;
            } else if (j > 0) {
                int t = nums[i];
                nums[i] = 0;
                nums[i-j] = t;
            }
        }
    }
}