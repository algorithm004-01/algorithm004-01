import java.util.HashMap;
import java.util.Map;

/**
 * _1TwoSum
 */
public class LeetCode_1_576 {
    //1. 暴力法，on2，两层for 循环遍历匹配
    public int[] twoSum1(int[] nums, int target) {
        //肌肉记忆的两层遍历数组的模版，三层遍历也要会，for (int k = 0; i < nums.length - 2; i++) 
        int[] res = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return new int[0];
    }
    
    //2.一遍哈希表，O(n),把数组元素的值和位置用hashmap存储，遍历条件target-nums[i],看是否有key存在，则取位置值为输出结果。
    //记住这种用hash表存储值来判断的思路
    public int[] twoSum2(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[1] = i;
                result[0] = map.get(target - nums[i]);
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }
}