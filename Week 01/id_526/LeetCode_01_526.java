class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null) {
            return null;
        }
        int[] result = new int[2];
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int numsLength = nums.length;
        for (int i = 0 ; i < numsLength ; i++ ) {
            Integer num = nums[i];
            if (map.containsKey(num)){
                result[0] = i;
                result[1] = map.get(num);
                return result;
            }
            map.put(target - num,i);
        }
        return result;
    }
}