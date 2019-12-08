package com.uanei;

public class LeetCode_53_286 {

    public int maxSubArray(int[] nums) {
        // 结果 = 要么自身最大，要么之前的结果加上自身最大
        int re = nums[0];
        int sum = 0;
        for (int num : nums) {
            // 大于0，则对结果有增益效果
            if (sum > 0) {
                sum += num;
            } else {
                // 小于等于0，说明没有啥用了，直接将sum更新为当前遍历的元素
                sum = num;
            }
            // 无论是单个元素还是多个元素的和，最大的值已经保留到结果当中
            re = Math.max(re, sum);
        }
        return re;
    }

}
