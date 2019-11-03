class Solution {
    // 暴力解法：遍历数组中元素并统计个数，出现n/2次以上的即为众数
    public int majorityElement(int[] nums) {
        int requiredCnt = nums.length / 2;
        Map<Integer,Integer> cntMap = new HashMap<>();
        for(int i = 0; i < nums.length ; i++){
            if(cntMap.containsKey(nums[i])) {
                if(cntMap.get(nums[i])+1 > requiredCnt)
                    return nums[i];
                else
                    cntMap.put(nums[i],cntMap.get(nums[i])+1);
            }else{
                cntMap.put(nums[i],1);
            }
            
        }
        return nums[0];
    }

    // 排序后，由于众数的定义，出现在数组中间位置的一定是众数
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    // 投票法：众数计1，非众数计-1。计数为0时重新设定候补众数
    // 由于为0时舍弃访问过的数字，则意味着舍弃n个众数的同时也舍弃了n个非众数
    // 在剩余数字里依然是最终的众数占多数
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }
}