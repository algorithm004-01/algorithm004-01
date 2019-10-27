package com.five;

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 */
public class MaxWaterAreaFive {
    //1.两次循环，暴力法
    //不重复遍历注意点：嵌套循环里面的下标初始值是第一层嵌套下标值+1，保证两个垂直线不重复，也能保证相同面积不重复。
    //时间复杂度为O(n^2)
    public int doubleLoop(int[] nums) {
        int maxArea=0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                maxArea = Math.max(maxArea,(j-i)*Math.min(nums[i],nums[j]));
            }
        }
        return maxArea;
    }
    //2.一开始不是很理解，最后在评论下放找到了一段话，这段话理解起来比较容易，很性感的一句话
    //我感觉可以这么理解：由于面积取决于边长短的那一端假设为m，所以要想得到比当前更大的面积，
    // 边长短的那一端必须舍弃因为如果不舍弃，高最大就是m，而随着指针的移动宽会一直减小，因此面积只会越来越小。
    //复杂度为O(n)
    public int convergenceLoop(int[] nums) {
        int i = 0;//left loop
        int j = nums.length-1;//right loop
        int maxArea = 0;
        while(i < j) {
            maxArea = Math.max(maxArea,(j-i)*Math.min(nums[i],nums[j]));
            if(nums[i] > nums[j]){
                j--;
            }else{
                i++;
            }
        }
        return maxArea;
    }

    //3.简介的方法编写,复杂度为O(n)
    public int convergenceLoopEasyCode(int[] nums) {
        int maxArea = 0;
        for(int i=0,j=nums.length-1;i<j;) {
            int minHeight = nums[i] < nums[j]? nums[i ++] : nums[j --];
            maxArea = Math.max(maxArea,minHeight*(j-i+1));
        }
        return maxArea;
    }
    
}
