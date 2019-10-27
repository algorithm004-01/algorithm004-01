class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 1) {
            return;
        }
        int zeroNums = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int value = nums[i];
            if (value == 0) {
                zeroNums++;
                continue;
            }
            if (zeroNums > 0) {
                nums[i] = 0;
                nums[i-zeroNums] = value;
            }
        }
    }
}