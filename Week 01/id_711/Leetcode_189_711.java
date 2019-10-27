package Week1;

public class Lettcode_189 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        rotate3(nums,k);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]) ;
        }
    }



    /**
     * 暴力解法，O(n*k)
     * 执行用时 : 126 ms , 在所有 java 提交中击败了22.49%的用户
     * 内存消耗 : 36.7 MB , 在所有 java 提交中击败了95.45%的用户
     * @param nums
     * @param k
     */
    private static void rotate1(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        for (int i = 0; i < k; i++) {
            int x = nums[len - 1];
            for (int j = len - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = x;
        }
    }

    /**
     * 开新的数组转存
     * 执行用时 :1 ms, 在所有 java 提交中击败了95.05%的用户
     * 内存消耗 :36.7 MB, 在所有 java 提交中击败了95.45%的用户
     */
    private static void rotate(int[] nums, int k) {
        int[] help = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            help[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = help[i];
        }
    }

    /**
     * 反转数组
     * 执行用时 :1 ms, 在所有 java 提交中击败了94.76%的用户
     * 内存消耗 :37.7 MB, 在所有 java 提交中击败了94.46%的用户
     */
    private static void rotate2(int[] nums, int k) {
        k %= nums.length;
        reverse(nums,0,nums.length - 1);
        reverse(nums,0,k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private static void reverse(int[] nums, int l, int r) {
        while (l < r){
            int t = nums[r];
            nums[r--] = nums[l];
            nums[l++] = t;
        }
    }

    /**
     * 环状替换
     * 执行用时 :1 ms, 在所有 java 提交中击败了94.76%的用户
     * 内存消耗 :37 MB, 在所有 java 提交中击败了95.45%的用户
     */
    private static void rotate3(int[] nums, int k) {
        k %= nums.length;
        int count = 0;
        for (int i = 0; count < nums.length; i++) {
            int current = i;
            int prev = nums[i];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            }
            while (i != current);
        }
    }
}
