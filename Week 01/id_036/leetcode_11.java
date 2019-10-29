package com.sslz.leetcode;

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class leetcode_11 {
    /**
     * 暴力求解
     * 暴力求解思维考点：对数组的使用，柱子的宽度 等价于数组的下标
     * 时间复杂度：O(N^2)
     *
     * @param nums
     * @return
     */
    public  int solution_01(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            // j = i+1 找到下一根柱子 i=0 代表左边界
            for (int j = i + 1; j < nums.length; j++) {
                int h = nums[i] < nums[j] ? nums[i] : nums[j];
                int area = h * (j - i);
                max = Math.max(max, area);
            }
        }
        return max;
    }

    /**
     * 题解二:双指针法
     * 定义两个指针，向中间靠拢，需要移动的指针就是较低的那根柱子
     * 时间复杂度：O(N)
     */
    public int solution_02(int[] nums) {
        int max = 0;
        //相当于一个死循环 弹出条件 i<j <==> while (i<j) { }
        for (int i = 0, j = nums.length - 1; i < j; ) {
            int area = Math.min(nums[i], nums[j]) * (j - i);
            nums[i] > nums[j] ? j-- : i++;
            max = Math.max(max, area);
        }
        return max;
    }

}
