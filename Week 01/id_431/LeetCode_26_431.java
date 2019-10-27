package simple;

/**
 * @author 潘磊明
 * @date 2019/10/20
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }else {
            int len = 1;
            for (int i = 0; i < nums.length - 1;) {
                int j = i + 1;
                while (j < nums.length && nums[j] == nums[i]){
                    j++;
                }
                if(j < nums.length){
                    i = j;
                    nums[len] = nums[i];
                    len++;
                }else{
                    i++;
                }
            }
            return len;
        }
    }
}
