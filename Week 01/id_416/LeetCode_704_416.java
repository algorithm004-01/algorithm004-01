package com.first;

import java.util.*;

/**
 * 二分查找
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target，
 * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * 示例 1:
 *
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 * 示例 2:
 *
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BinarySearch {
    //1.loop search,it is O (n)
    protected int _getIndexByLoopSearch(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(num == target) {
                return i;
            }
        }
        return -1;
    }
    //2.split search
    public int _getIndexBySplitSearch(int[] nums, int target, int splitNumsIndex) {

        if(nums[splitNumsIndex] > target) {//从左边找
            splitNumsIndex = splitNumsIndex/2;
            return _getIndexBySplitSearch(nums,target,splitNumsIndex);
        }

        if(nums[splitNumsIndex] < target) {//从右边找
            splitNumsIndex = splitNumsIndex+(nums.length-splitNumsIndex)/2;
            return _getIndexBySplitSearch(nums,target,splitNumsIndex);
        }

        if(nums[splitNumsIndex] == target) {
            return splitNumsIndex;
        }
        return -1;
    }
}
