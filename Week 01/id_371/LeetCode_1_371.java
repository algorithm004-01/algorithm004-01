import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-10-19 22:02
 **/

public class LeetCode_1_371 {

    public static void main(String[] args) {
//        int[] nums = {2, 7, 11, 15};
        int[] nums = {3,2,4};
        int target = 6;
        int[] twoSum = twoSum1(nums, target);
        Arrays.stream(twoSum).forEach(System.out::println);

    }

    /**
     * 重解1:
     * @author Shaobo.Qian
     * @date 2019/11/9
     */
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (map.containsKey(key)) {
                return new int[]{map.get(key), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }




    public static int[] twoSum(int[] nums, int target) {
        //遍历数组,将数组元素相加和目标值比较
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        //遍历数组,将数组元素相加和目标值比较
        for (int i = 0; i < nums.length; i++) {
            //判断当前元素能组成 target,不能存入 map,可以返回
            int key = target - nums[i];
            if (map.containsKey(key)) {
                return new int[]{map.get(key), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

}
