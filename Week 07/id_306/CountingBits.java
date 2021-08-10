package sf.week7;

/**
 * Created by LynnSun on 2019/12/3.
 * 力扣题目地址：https://leetcode-cn.com/problems/counting-bits
 */
public class CountingBits {
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; ++i)
            ans[i] = ans[i & (i - 1)] + 1;
        return ans;
    }
}
