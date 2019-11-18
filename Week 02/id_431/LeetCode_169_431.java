package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 潘磊明
 * @date 2019/10/27
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) > (nums.length / 2) + 1) {
                return key;
            }
        }
        return -1;
    }
}
