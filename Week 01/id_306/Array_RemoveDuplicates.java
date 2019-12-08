
public class Array_RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (0==nums.length) {
            return 0;
        }
        int j = 0;
        for (int i = 1; i< nums.length; i++) {
            if (nums[i] != nums[j]) {
                nums[++j] = nums[i];
            }
        }
        return j + 1;
    }
}
