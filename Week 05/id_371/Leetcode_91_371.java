/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-11-22 08:07
 **/

public class Leetcode_91_371 {//"01" ==>0 ("01"无法编码)

    /**
     * 仿解1:dp-->自底向上(爬楼梯问题,每次可以爬1步也可以爬2步)
     *
     * @author Shaobo.Qian
     * @date 2019/11/30
     * @link https://leetcode-cn.com/problems/decode-ways/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-2-3/
     */
    public int numDecodings(String s) {
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[len] = 1;
        if (s.charAt(len - 1) != '0') {
            dp[len - 1] = 1;
        }
        for (int i = len - 2; i >= 0; i--) {
            if(s.charAt(i) == '0') continue;
            int ans1 = dp[i + 1];
            int ten = (s.charAt(i) - '0') * 10;
            int one = s.charAt(i + 1) - '0';
            int ans2 = 0;
            if (ten + one <= 26) {
                ans2 = dp[i + 2];
            }
            dp[i] = ans1 + ans2;
        }
        return dp[0];
    }

    /**
     * 仿解2:优化空间
     * @author Shaobo.Qian
     * @date 2019/11/30
     */
    public int numDecodings1(String s) {
        int len = s.length();
        int end = 1;//初始化
        int cur = 0;
        if(s.charAt(len-1) != '0') cur = 1;
        for (int i = len - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                end = cur; //end 前移(记录前面一层的解个数)
                cur = 0;
                continue;
            }
            int ans1 = cur;
            int ans2 = 0;
            int ten = (s.charAt(i) - '0') * 10;
            int one = (s.charAt(i + 1) - '0');
            if (ten + one <= 26) ans2 = end;
            end = cur;//end 前移(记录前面一层的解个数)
            cur = ans1 + ans2;

        }
        return cur;
    }

}
