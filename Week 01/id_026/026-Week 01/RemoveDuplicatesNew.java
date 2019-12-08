// 删除排序数组中的重复项
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] a = {1,1,2};
        RemoveDuplicates r = new RemoveDuplicates();
        r.removeDuplicates(a);
    }

}
