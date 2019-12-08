package id_031;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/two-sum 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class LeetCode_1_031 {

  // 1. 暴力法 两层循环
  // 2. 哈希表法（由于结果为返回下标，故需保存 num 对应的下标）

  /**
   * 哈希表法
   */
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>(nums.length);

    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], i);
    }

    for (int i = 0; i < nums.length; i++) {
      int matchNum = target - nums[i];
      Integer matchKey = map.get(matchNum);
      //确保存在且与当前值不为同一位置的值
      if (matchKey != null && matchKey != i) {
        return new int[]{i, matchKey};
      }
    }
    return new int[]{0, 0};
  }

  /**
   * 暴力法
   */
  public int[] twoSum2(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if ((nums[i] + nums[j]) == target) {
          return new int[]{i, j};
        }
      }
    }

    //找不到答案
    return new int[]{0, 0};
  }

  //

  public static void main(String[] args) {
    int[] nums = new int[]{3, 2, 4};
    int target = 6;
    int[] result = new LeetCode_1_031().twoSum(nums, target);
    System.out.println(Arrays.toString(result));

  }
}