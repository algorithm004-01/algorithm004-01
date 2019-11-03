package majorityElement;

import java.util.HashMap;
import java.util.Map;

/**
 *
 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 你可以假设数组是非空的，并且给定的数组总是存在众数。

 示例 1:

 输入: [3,2,3]
 输出: 3
 示例 2:

 输入: [2,2,1,1,1,2,2]
 输出: 2
 *
 * */
class Solution {
    public int majorityElement(int[] nums) {
        //分治
        return majorityElementEc(nums,0,nums.length-1);

    }

    private int majorityElementEc(int[] nums, int lo, int hi) {
        // terminator
        if(lo == hi) return nums[lo];
        // process current logic
        int mid = (hi-lo)/2+lo;
        int left = majorityElementEc(nums,lo,mid);
        int right = majorityElementEc(nums,mid+1,hi);
        if(left == right) return left;
        // merge
        int leftCount = countInRange(nums,left,lo,mid);
        int rightCount = countInRange(nums,right,mid,hi);

        return leftCount > rightCount ? left : right;


    }

    private int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi ; i++){
            if(nums[i] == num) count++;
        }
        return count;
    }
//    public int majorityElement(int[] nums) {
//        //哈希表法
//        //将数组内的元素及重复个数存放在map中
//        Map<Integer,Integer> map = new HashMap<>();
//        //map中最大元素及个数存放
//        int maxNum = 0; int maxCount = 0;
//        //遍历元素
//        for(int num : nums){
//            int count = map.getOrDefault(num,0)+1;
//            map.put(num,count);
//            if(count > maxCount){
//                maxNum = num;
//                maxCount = count;
//            }
//        }
//        return maxNum;
//    }
}