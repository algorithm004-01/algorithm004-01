import java.util.HashMap;
import java.util.Map;

/**
 * @auther: TKQ
 * @Title: TwoSum_1
 * @Copyright: Copyright (c) 2019
 * @Description:
 * @Company:
 * @Created: 2019-11-02 10:01
 */
public class TwoSum_1 {
    public int[] twoSum(int[] nums, int target) {
        if(nums.length<2){
            return null;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                return new int[]{map.get(nums[i]),i};
            }
            map.put(target - nums[i],i);
        }
        return null;
    }
}
