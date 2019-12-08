import java.util.HashMap;
import java.util.Map;

/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-11-05 08:28
 **/

public class Leetcode_169_371 {

    public static void main(String[] args) {

        int[] nums = {2, 2, 1, 1, 1, 2, 2};
//        int[] nums = {3, 2, 3};
        int target = majorityElement1(nums);
        System.out.println("target = " + target);
    }


    /**
     * 仿解1:分治
     *
     * @author Shaobo.Qian
     * @date 2019/11/5
     */
    public static int majorityElement1(int[] nums) {

        return divideConquer(nums, 0, nums.length - 1);
    }

    private static int divideConquer(int[] nums, int lo, int hi) {
        //1.递归出口
        if (lo == hi) {
            return nums[lo];
        }

        //2.处理子问题
        int mid = lo + (hi - lo) / 2;
        int left = divideConquer(nums, lo, mid);
        int right = divideConquer(nums, mid + 1, hi);
        //3.合并结果
        if (left == right) {
            return left;
        } else {
            int leftCount = countMajorityElement(nums, left, lo, mid);
            int rightCount = countMajorityElement(nums, right, mid + 1, hi);
            return leftCount > rightCount ? left : right;
        }
    }

    /**
     * 计算在左右half 数组中中位数出现的次数
     * @author Shaobo.Qian
     * @date 2019/11/5
     */
    private static int countMajorityElement(int[] nums, int majority, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == majority) count++;
        }
        return count;
    }

    /**
     * 原解1: map(是否存在-->map)
     *
     * @author Shaobo.Qian
     * @date 2019/11/5
     */
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer count = 0;
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
                count = 1;
            } else {
                count = map.get(nums[i]) + 1;
                map.put(nums[i], count);
            }
            if (2 * count > nums.length) {
                return nums[i];
            }
        }
        return 0;
    }

}
