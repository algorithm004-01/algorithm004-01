package simple;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 在一个整形数组中，找出两个数相加的和与目标值相等，返回这两个数的索引。
 * 可以确定一个整形数组中有且仅有一组符合要求的值，
 */
public class TwoSum {

    /**
     * 暴力求解
     * 时间复杂度O(n^2)
     * 空间复杂度O(1)
     * @param nums
     * @param target
     * @return
     */
//    public int[] twoSum(int[] nums, int target) {
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target) {
//                    return new int[]{i, j};
//                }
//            }
//        }
//        return null;
//    }

    /**
     * 运用hashMap进行临时存值
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        //使用个Hash表进行临时存值
        //key为元素的值，value为元素的索引
        HashMap<Integer,Integer> map = new HashMap<>(nums.length);
        //设置初始值
        map.put(nums[0], 0);
        //开始循环
        for (int i = 1; i < nums.length; i++) {
            if(map.containsKey((target - nums[i]))){
                return new int[]{map.get(target - nums[i]), i};
            }else{
                map.put(nums[i], i);
            }
        }
        return null;
    }
}
