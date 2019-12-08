class Solution {
    public int rob(int[] nums) {
        int preTwo = 0;
        int pre = 0;
        int max = pre;

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(preTwo + nums[i], pre);
            preTwo = pre;
            pre = max;
        }

        return max;
    }
}