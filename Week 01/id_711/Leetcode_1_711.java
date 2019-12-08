package Week1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Lettcode_001 {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 13;
        int[] array = twoSum(nums,target);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 思路：用map存储当前值与target的差值，遍历到这个差值即为答案
     * 执行用时 :3 ms, 在所有 java 提交中击败了98.88%的用户
     * 内存消耗 :37.3 MB, 在所有 java 提交中击败了89.88%的用户
     * @param nums
     * @param target
     * @return
     */
    private static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int[] ans = {map.get(nums[i]),i};
                return ans;
            }
            else {
                map.put(target - nums[i],i);
            }
        }
        return null;
    }
}
