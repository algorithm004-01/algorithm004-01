package cn.leetcode;

public class LeetCode_189_351 {

    public static void main(String[] args) {

        App app = new App();
        int nums[] = {1, 2, 3, 4, 5, 6, 7};
        //7,6,5,4,3,2,1
        //5,6,7,1,2,3,4
        //7654321
        int k = 3;
        app.rotate(nums, k);
        for (int i : nums) {
            System.out.println(i);
        }
    }

    static class App {
        public void rotate(int[] nums, int k) {
            //整体反转一次,如输入1,2,3,4,5,6,7,则变成7,6,5,4,3,2,1
            k %= nums.length;
            reverse(nums, 0, nums.length - 1);
            //k前面的元素反转
            reverse(nums, 0, k - 1);
            //k之后的元素反转
            reverse(nums, k, nums.length - 1);
        }

        //反转
        private void reverse(int[] nums, int start, int end) {
            for (; start < end; start++, end--) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
            }

        }
    }
}
