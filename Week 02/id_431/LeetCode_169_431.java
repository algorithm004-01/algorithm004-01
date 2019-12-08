package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 潘磊明
 * @date 2019/10/27
 */
public class MajorityElement {

//    public int majorityElement(int[] nums) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (map.containsKey(nums[i])) {
//                map.put(nums[i], map.get(nums[i]) + 1);
//            } else {
//                map.put(nums[i], 1);
//            }
//        }
//        for (Integer key : map.keySet()) {
//            if (map.get(key) > (nums.length / 2) + 1) {
//                return key;
//            }
//        }
//        return -1;
//    }

//    public int majorityElement(int[] nums) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (!map.containsKey(nums[i])) map.put(nums[i], 0);
//            map.put(nums[i], map.get(nums[i]) + 1);
//        }
//        for (Integer key : map.keySet()) {
//            if (map.get(key) > nums.length / 2) return key;
//        }
//        return -1;
//    }

    /**
     * 解题思路：因为众数会至少出现n/2次，所以用一个变量标志众数，一个变量标志数量，
     * 当数量为0时，则数量加1并将当前数标志为众数，当当前数和众数不一致时，数量减1，
     * 当当前数与众数一致时，数量加1
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums){
        int majority = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {majority = nums[i]; count = 1;}
            else if (majority != nums[i]) count--;
            else if (majority == nums[i]) count++;
        }
        return majority;
    }
}
