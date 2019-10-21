package homework.week01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * https://leetcode-cn.com/problems/two-sum/
 */
public class TwoSum{

    /**
     * 暴力法
     * 思路：双层for循环，第一个和第二个相加，第一个和第三个相加，... 复杂度O(n*n)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i = 0;i < nums.length - 1; i ++) {
            for(int j = i + 1; j < nums.length; j ++){
                if(nums[i] + nums [j] == target){
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    /**
     * 思路：
     * target - nums[i] = hashMap.get(j)说明匹配整取
     * map 存储的key为nums的数值，value为nums的索引
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer,Integer> sumMap = new HashMap<>();
        int dstNum;
        Integer index;
        for(int i = 0; i < nums.length; i++) {
            dstNum = target - nums[i];
            index = sumMap.get(dstNum);
            if(index != null){
                result[0] = i;
                result[1] = index;
                return result; 
            }
            sumMap.put(nums[i], i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int []{2, 7, 11, 15};
        // int[] result = twoSum(nums, 9);
        int[] result = twoSum2(nums, 9);
        System.out.println(Arrays.toString(result));
    }
}