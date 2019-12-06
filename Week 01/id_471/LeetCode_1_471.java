//使用map缓存已经遍历过的数字，然后在遍历过程中再看map中有没有满足与当前数字之和为 target 的值
//时间复杂度为：O(n)
//空间复杂度为：O(n)

class Solution {
   public int[] twoSum(int[] nums, int target) {
       Map<Integer, Integer> map = new HashMap<Integer, Integer>();
       for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]), i};
            }
            map.put(nums[i], i);
        }
       
       return new int[]{0,0};
    }
}