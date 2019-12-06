import java.util.*;
/**
 * 求众数
 */
public class Solution {
    /**
     * 求众数(基于循环计数)
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int count = 1;
        int num = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1])
                count++;
            else {
                if (count > nums.length / 2)
                    return nums[i];
                count = 1;
            }
            num = nums[i];
        }
        return num;
    }

    /**
     * 求众数(基于边界)
     */
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 求众数(基于投票法)
     */
    public int majorityElement3(int[] nums) {
        int num = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                num = nums[i];
                count = 1;
            } else if (num == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return num;
    }

    /**
     * 求众数(基于投票法 - 改进版)
     */
    public int majorityElement4(int[] nums) {
        int num = nums[0];
        int count = 0;
        for (int value : nums) {
            if (count == 0) num = value;
            count += ((num == value) ? 1 : -1);
        }
        return num;
    }
}