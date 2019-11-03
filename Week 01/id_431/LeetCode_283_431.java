package simple;

/**
 * @author 潘磊明
 * @date 2019/10/18
 */
public class MoveZeros {
    public void moveZeroes(int[] nums) {
        int i = 0, j = -1;
        while (i < nums.length) {
            if (nums[i] == 0) {
                j = j == -1 ? j = i : j++;
            }else if (j != -1) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                j++;
            }
            i++;
        }
    }
}
