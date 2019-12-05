package bit;

/**
 * @author alis
 * @date 2019/12/1 10:41 AM
 * @description
 */
public class LeetCode_231_721 {
    /**
     * 题意：判断一个数字是否为2的次幂数
     *
     * */
    public boolean isPowerOfTwo(int n) {
        return (n != 0) && (n & (n - 1)) == 0;
    }
}
