package sf.week7;

/**
 * Created by LynnSun on 2019/12/3.
 * 力扣题目地址：https://leetcode-cn.com/problems/power-of-two
 */
public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n<=0)
            return false;
        while (n != 0) {
            if ((n & 1) != 0)// 判断是否末位是1
            {
                if (n == 1)
                    return true;
                else
                    return false;
            }
            n = n >> 1;
        }
        return true;
    }

    public boolean isPowerOfTwoOther(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
