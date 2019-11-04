import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import com.sun.tools.javac.code.Type.ForAll;
import com.sun.tools.javac.util.List;

/**
 * _15ThreeSums
 */
public class _15ThreeSums {
    //1. 暴力法，O(n^3)
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] == -nums[k]) {
                        res.add(new ArrayList<Integer>(Arrays.asList(nums[i],nums[j],nums[k])));
                    }
                }
            }
        }
        return res;
    }

    //2. hash table
    //3. 双指针逼近
    public List<List<Integer>> threeSum3(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < nums.length - 2; i++) {//遍历target
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                //确定双指针左右边界和target值
                int lo = i + 1, hi = nums.length - 1, sum = 0 - nums[i];
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == sum) {
                        res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        //跳过重复解
                        while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                        while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
                        lo++; hi--;
                    } else if (nums[lo] + nums[hi] < sum) lo++;//说明lo值小了
                    else hi--;
                }
            }
        }
        return res;
    }    
}

