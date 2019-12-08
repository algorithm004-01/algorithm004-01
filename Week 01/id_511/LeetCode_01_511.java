package id_511;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0
 * @Description: 两数之和
 * @author: hxw
 * @date: 2019/4/8 21:56
 */
public class LeetCode_01_511 {

    //方法一：暴力法，一个一个进行比对，时间复杂度O(n^2)
    public int[] twoSum1(int[] nums, int target) {
        int arr[] = new int[2];
        int b;
        for(int i=0;i<=nums.length;i++){
            for(int a=0,j=i+1;a<=(b=(nums.length-i-1));a++){
                if(j<=nums.length-1 && (nums[i]+nums[j])==target){
                    arr[0] = i;
                    arr[1] = j;
                    return arr;
                }
                j++;
            }
        }
        return null;
    }

    //方法二：两遍哈希表 时间复杂度O(n) 遍历了两次，即2n
    public int[] twoSum2(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) { //第一次遍历将数组元素和索引一一对应存到hash表中
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i]; //检查每个元素所对应的目标元素（target - nums[i]）是否存在于hash表中
            if (map.containsKey(complement) && map.get(complement) != i) { //如果存在并且不是自身则说明是满足条件的
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    //方法三: 一遍哈希表  使用hashMap，数组内容为key，索引为value，循环查找，在put当前数之前进行一次containsKey查询
    public int[] twoSum3(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args){
        int nums[] = {5, 7, 11, 15};
        //int nums[] = {3,2,4};
        int target = 10;
        LeetCode_01_511 leetCode01511 = new LeetCode_01_511();
        int[] ints = leetCode01511.twoSum3(nums, target);
        System.out.println(Arrays.toString(ints));
    }
}
