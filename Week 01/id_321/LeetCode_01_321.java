package week01;

import java.util.HashMap;

public class Twosum1 {
	public int[] twoSum(int[] nums, int target) {
		int length = nums.length;
		int[] result = new int[2];

		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < length; i++) {
			if (map.containsKey(target - nums[i])) {
				result[0] = map.get(target - nums[i]);
				result[1] = i;
				return result;
			}
			map.put(nums[i], i);
		}
		return result;
	}

}
