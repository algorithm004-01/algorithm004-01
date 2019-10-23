package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 潘磊明
 * @date 2019/10/20
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        //首先对数组进行排序
        Arrays.sort(nums);
        //设置引用变量
        List<List<Integer>> result = new ArrayList<>();
        for (int k = 0; k < nums.length - 2; k++) {
            if (k == 0 || (k > 0 && nums[k] != nums[k-1])) {
                int i = k + 1, j = nums.length - 1;
                while (i < j) {
                    if (nums[i] + nums[j] < -nums[k])
                        i++;
                    else if (nums[i] + nums[j] > -nums[k])
                        j--;
                    else {
                        List<Integer> tmp = Arrays.asList(nums[k], nums[i], nums[j]);
                        result.add(tmp);
                        while (i < j && nums[i + 1] == nums[i]) i++;
                        while (i < j && nums[j] == nums[j - 1]) j--;
                        i++;
                        j--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum t = new ThreeSum();
        t.threeSum(new int[]{
                1,-1,-1,0
        });
    }
}
