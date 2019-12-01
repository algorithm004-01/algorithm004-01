package homework.week07;

/**
 * 231. 2的幂
 * https://leetcode-cn.com/problems/power-of-two/
 * @author tangxy
 * @date 2019-12-01
 */
public class LeetCode_231_501 {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
