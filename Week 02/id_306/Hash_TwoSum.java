import java.util.HashMap;
import java.util.Map;

/**
 * Created by LynnSun on 2019/10/23.
 */
public class Hash_TwoSum {
    /**
     * 暴力
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 两遍Hash表
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 一遍Hash表
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
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

    /**
     * leetcode上第一名大佬的解法
     * 这里我谈谈对第一名的答案的理解（该代码不是我写的）：
     * 我认为使用的是一种类似于自己创建一个简单的哈希表的方法，indexArrays为那个哈希表，
     * indexArrays中存放的其实是nums中元素的位置。而其中的diff & indexArrayMax我认为一是为了解决可能存在的负数的情况，
     * 二是为了解决nums中数值过大的情况，& indexArrayMax能够使nums中无论是什么数都能被约束到0-2047之间。
     * 总的来说，这样做是比java自带的hashmap要快一点，但是思路是一样的。
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum_Others(int[] nums, int target) {
        int indexArrayMax = 2047;
        int[] indexArrays = new int[indexArrayMax + 1];
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            int index = diff & indexArrayMax;
            if (indexArrays[index] != 0) {
                return new int[] { indexArrays[index] - 1, i };
            }
            indexArrays[nums[i] & indexArrayMax] = i + 1;
        }
        throw new IllegalArgumentException("No two sum value");
    }
}
