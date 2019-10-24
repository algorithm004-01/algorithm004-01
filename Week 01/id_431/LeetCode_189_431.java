package simple;

/**
 * @author 潘磊明
 * @date 2019/10/20
 */
public class RotateArray {
    /**
     * 暴力求解
     * @param nums
     * @param k
     */
//    public void rotate(int[] nums, int k) {
//        for (int i = 0; i < k; i++) {
//            int tmp = nums[nums.length - 1];
//            for(int j = nums.length - 2; j > -1; j--) {
//                nums[j + 1] = nums[j];
//            }
//            nums[0] = tmp;
//        }
//    }

    /**
     * 使用一个长度为k的数组进行临时存放
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        if (nums.length < k) {
            k = k - nums.length;
        }
        int[] tmp = new int[k];
        for (int j = 0; j < k; j++){
            tmp[k - j - 1] = nums[nums.length - 1 - j];
        }
        for (int i = 0; i < nums.length - k; i++) {
            nums[nums.length - 1 - i] = nums[nums.length -1 - i - k];
        }
        for (int i = 0; i < k; i++) {
            nums[i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        RotateArray rotateArray = new RotateArray();
        rotateArray.rotate(new int[]{
                1,2,3,4,5,6,7
        }, 3);
    }
}
