

import java.util.HashMap;

public class LeetCode_1_136 {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            map.put(Integer.valueOf(nums[i]), i);
        }

        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(target - nums[i]);
            if (index != null && index.intValue() != i) {
                return new int[]{i, index.intValue()};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] ns = {2,7,11,15};

        int[] ints = new LeetCode_1_136().twoSum(ns, 9);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(i + ",");
        }
    }
}
