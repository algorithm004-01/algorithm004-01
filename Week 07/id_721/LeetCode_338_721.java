package bit;

/**
 * @author alis
 * @date 2019/12/1 5:33 PM
 * @description
 */
public class LeetCode_338_721 {
    /**
     * 题意： 判断一个正整数，在0<i<=n范围内，每个数字，二进制位中到1的个数
     * 思路
     * 1. 拆分 -> foreach 判断每个数字的二进制格式包含多少个1 -> 位运算 x & (x-1) 取出二进制位的最后一个1，并统计其次数
     */
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; ++i) {
            res[i] = countBit(i);
        }
        return res;
    }

    private int countBit(int x) {
        int count = 0;
        while (x != 0) {
            count++;
            x &= (x - 1);
        }
        return count;
    }

    /**
     * 动态规划 + 最高有效位
     * <p>
     * DP解法
     * 从观察规律 0(0), 1(1), 2(10), 3(11) 看
     * 2的二进制比 0 多一个1
     * 3的二进制比 1 多一个1
     * 根据状态转移，得出dp方程
     * p(x+b) = p(x) + 1, b = 2^m
     */
    public int[] countBitsDP1(int n) {
        int[] ans = new int[n + 1];
        int i = 0, b = 1;
        while (b <= n) {
            // 求每一层子问题： 比如 求 2，3整数的统计， 可以由0，1得到 ; 而b可以理解为 b=3-1=2-0这个规律
            while (i < b && i + b <= n) {
                ans[i + b] = ans[i] + 1;
                ++i;
            }
            i = 0;
            b <<= 1; // b=2b 也就是求b在每一层子问题的上限
        }
        return ans;
    }

    /**
     * dp方程
     * P(x)=P(x/2)+(xmod2)
     */
    public int[] countBitsDP2(int n) {
        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }
}
