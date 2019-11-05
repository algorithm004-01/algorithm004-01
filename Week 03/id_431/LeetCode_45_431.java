package hard;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author 潘磊明
 * @date 2019/11/5
 */
public class JumpGameII {
    public int jump(int[] nums) {
        int end = 0, maxIndex = 0, jump = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxIndex = Math.max(maxIndex, i + nums[i]);
            if (i == end) {
                end = maxIndex;
                jump++;
            }
        }
        return jump;
    }

}
