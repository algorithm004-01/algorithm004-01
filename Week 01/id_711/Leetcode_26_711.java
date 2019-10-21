package Week1;

public class Lettcode_026 {
    public static void main(String[] args) {
        int[] nums = {};
        System.out.println(removeDuplicates(nums));
    }

    /**
     * 执行用时 :1 ms, 在所有 java 提交中击败了100.00%的用户
     * 内存消耗 :39.6 MB, 在所有 java 提交中击败了95.94%的用户
     * @param nums
     * @return
     */
    private static int removeDuplicates(int[] nums) {
        if (nums.length < 1)
            return 0;
        int length = 1;
        int x = nums[0];
        int index = 1;
        while (index < nums.length){
            if (nums[index] != x) {
                nums[length++] = nums[index];
                x = nums[index];
            }
            index++;
        }
        return length;
    }

    /**
     * 最优版
     */
    private static int solution(int[] nums) {
        if (nums.length < 1)
            return 0;
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}
