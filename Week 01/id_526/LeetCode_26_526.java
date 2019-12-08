class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int length = nums.length;
        if (length < 2) {
            return length;
        }
        int minNum = nums[0];
        int replace = 1;
        for (int i = 1;i < length; i++){
            if (nums[i] == minNum) {
                continue;
            }
            nums[replace] = nums[i];
            minNum = nums[i];
            replace++;
        }
        return replace;
    }
}