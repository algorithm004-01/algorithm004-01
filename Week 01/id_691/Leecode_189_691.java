public class Solution {
    public void rotateSimple(int[] nums, int k) {
        //暴力
        int temp,previous;
        for (int i = 0; i < k; i++){
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++){
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }

        }
    }

    public void rotateAdditionalArray(int[] nums,int k){
        int[] a = new int[nums.length];
        for(int i = 0;i < nums.length; i++){
            a[(i+k) % nums.length] = nums[i];
        }
        for (int i = 0;i < nums.length; i++) {
            nums[i] = a[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        Solution s = new Solution();
        s.rotateSimple(nums,3);
    }

    //使用反转
    public void rorate(int[] nums,int k){
        k %= nums.length;
        reverse(nums,k,nums.length- 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start ++;
            end--;
        }
    }
