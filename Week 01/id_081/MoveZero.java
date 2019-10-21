/**
 * MoveZero
 */
public class MoveZero {
    public static void moveZeroes(int[] nums) {
        int p1 = 0;
        for (int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                int temp = nums[p1];
                nums[p1] = nums[i];
                nums[i] = temp;
                p1++;
            }
        }
    } 
}