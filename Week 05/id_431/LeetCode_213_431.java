package medium;

/**
 * @author 潘磊明
 * @date 2019/11/13
 */
public class HouseRobberII {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int max = 0, fir = 0, sec = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(sec, fir + nums[i]);
            fir = sec;
            sec = max;
        }
        int max1 = 0;
        fir = 0; sec = 0;
        for (int i = 1; i < nums.length; i++) {
            max1 = Math.max(sec, fir + nums[i]);
            fir = sec;
            sec = max1;
        }
        return Math.max(max, max1);
    }
}
