twoSum Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> sortedList = new HashMap<>(nums.length);
        int[] result = new int[2];
        for(int i = 0 ; i < nums.length; i++){
            if(sortedList.containsKey(target - nums[i])){
                result[0] = i;
                result[1] = sortedList.get(target - nums[i]);
            } else {
                sortedList.put(nums[i], i);
            }
        }
        
        return result;
    }
}
