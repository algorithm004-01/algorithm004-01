import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    /*public int[] twoSum(int[] nums, int target) {
        //Arrays.sort(nums);
        int[] index = new int[2];
        for (int i=0;i<nums.length-1;++i) {
            for (int j=i+1;j<nums.length;++j) {
                int sum = nums[i] + nums[j];
                if (sum == target) {
                   index[0] = i;
                   index[1] = j;
                   return index;
                }
            }
        }
        return index;
    }*/
    /* public int[] twoSum(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();

        for (int i=0;i<nums.length;++i) {
            map.put(nums[i], i);
        }

        for (int i=0;i<nums.length;++i) {
            int commpont = target-nums[i];
            if(map.containsKey(commpont) && map.get(commpont) != i){
                return new int[]{i,map.get(commpont)};
            }
        }
        throw new IllegalArgumentException("No two sum is"+target);
    }*/

    /*public int[] twoSum(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();

        for (int i=0;i<nums.length;++i) {
            int complement = target-nums[i];
            if (map.containsKey(complement)) {
                return new int[]{i,map.get(complement)};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum is"+target);
    }*/

}
