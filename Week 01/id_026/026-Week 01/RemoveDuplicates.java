// 删除排序数组中的重复项
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int j = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (j = i + 1; j < length; j++) {
                if (nums[i] == nums[j]) {
                    for(int k = j; k < length-1; k++){
                        nums[k] = nums[k+1];
                    }
                    j--;
                    length--;
                }
            }
        }
        return length;

    }

    public static void main(String[] args) {
        int[] a = {1,1,2};
        RemoveDuplicates r = new RemoveDuplicates();
        r.removeDuplicates(a);
    }

}
