package vip.ruoyun.week2.lesson8;

import java.util.HashMap;
import java.util.zip.CheckedOutputStream;

/**
 * https://leetcode-cn.com/problems/majority-element/description/
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 */
public class Leetcode169 {

    //方法一:暴力求解,计算每个数出现的次数,最后如果结果大于 length/2 那么就是众数.
    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> resMap = new HashMap<>();
        for (int num : nums) {
            Integer integer = resMap.get(num);
            if (integer == null) {
                integer = 1;
            } else {
                integer += 1;
            }
            resMap.put(num, integer);
            if (integer > nums.length / 2) {
                return num;
            }
        }
        return -1;
    }

    //方法二:暴力 双重 for
    public static int majorityElement2(int[] nums) {
        int majorityNum = nums.length / 2;
        for (int num : nums) {
            int count = 0;
            for (int elem : nums) {
                if (elem == num) {
                    count++;
                }
            }
            if (count > majorityNum) {
                return num;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(nums));
        System.out.println(majorityElement2(nums));
    }
}


