package sf.week5;

/**
 * Created by LynnSun on 2019/11/19.
 * 力扣题目地址：https://leetcode-cn.com/problems/decode-ways/
 */
public class DecodeWays {
    /**
     * dp 方法一空间占用较大
     * @param s
     * @return
     */
    public int numDecodings(String s) {

        int len = s.length();
        int[] dp = new int[len + 1];
        dp[len] = 1; //将递归法的结束条件初始化为 1
        //最后一个数字不等于 0 就初始化为 1
        if (s.charAt(len - 1) != '0') {
            dp[len - 1] = 1;
        }
        for (int i = len - 2; i >= 0; i--) {
            //当前数字时 0 ，直接跳过，0 不代表任何字母
            if (s.charAt(i) == '0') {
                continue;
            }
            int ans1 = dp[i + 1];
            //判断两个字母组成的数字是否小于等于 26
            int ans2 = 0;
            int ten = (s.charAt(i) - '0') * 10;
            int one = s.charAt(i + 1) - '0';
            if (ten + one <= 26) {
                ans2 = dp[i + 2];
            }
            dp[i] = ans1 + ans2;

        }
        return dp[0];
    }

    /**
     * dp 方法二 优化空间
     * @param s
     * @return
     */
    public int numDecodings1(String s) {
        int len = s.length();
        int[] dp = new int[3];
        dp[len % 3] = 1;
        if (s.charAt(len - 1) != '0') {
            dp[(len - 1) % 3] = 1;
        }
        for (int i = len - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp[i % 3] = 0; //这里很重要，因为空间复用了，不要忘记归零
                continue;
            }
            int ans1 = dp[(i + 1) % 3];
            int ans2 = 0;
            int ten = (s.charAt(i) - '0') * 10;
            int one = s.charAt(i + 1) - '0';
            if (ten + one <= 26) {
                ans2 = dp[(i + 2) % 3];
            }
            dp[i % 3] = ans1 + ans2;

        }
        return dp[0];
    }

    /**
     * dp 方法二 再次优化空间
     * @param s
     * @return
     */
    public int numDecodings5(String s) {
        int len = s.length();
        int end = 1;
        int cur = 0;
        if (s.charAt(len - 1) != '0') {
            cur = 1;
        }
        for (int i = len - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                end = cur;//end 前移
                cur = 0;
                continue;
            }
            int ans1 = cur;
            int ans2 = 0;
            int ten = (s.charAt(i) - '0') * 10;
            int one = s.charAt(i + 1) - '0';
            if (ten + one <= 26) {
                ans2 = end;
            }
            end = cur; //end 前移
            cur = ans1 + ans2;

        }
        return cur;
    }
}
