package medium;

/**
 * @author 潘磊明
 * @date 2019/11/5
 */
public class JumpGame {
//    /**
//     * Time limit
//     * @param nums
//     * @return
//     */
//    public boolean canJump(int[] nums) {
//        return _canJump(nums, 0);
//    }
//
//    private boolean _canJump(int[] nums, int index){
//        if (index < nums.length && nums.length - 1 - index <= nums[index]) {
//            return true;
//        }
//        int val = nums[index];
//        while (val > 0) {
//            boolean flag = _canJump(nums, index + val);
//            if (flag) return true;
//            else val--;
//        }
//        return false;
//    }

    /**
     * 循环nums判断当前的最大值是否大于等于数组的索引
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i <= max; i++) {
            max = Math.max(max, i + nums[i]);
            if (max >= nums.length - 1) return true;
        }
        return false;
    }

}
