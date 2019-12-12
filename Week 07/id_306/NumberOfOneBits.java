package sf.week7;

/**
 * Created by LynnSun on 2019/12/3.
 * 力扣题目地址：https://leetcode-cn.com/problems/number-of-1-bits/
 */
public class NumberOfOneBits {
    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }
}
