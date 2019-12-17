class Solution {
    //暴力求解
    public void rotate(int[] nums, int k) {
        if (nums == null) {
            return;
        }
        int n = nums.length;
        k = k % n;
        for (int i = 0; i < k ; i++) {
            int temp = nums[n-1];
            for (int j = n -1 ; j > 0 ; j--) {
                nums[j] = nums[j-1];
            }
            nums[0] = temp;
        }
    }
    /**
     * 分3步翻转
     * 1. 反转全部元素
     * 2. 反转0-k个元素
     * 3. 反转剩余的0-n-k个元素
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        if (nums == null){
            return;
        }
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}