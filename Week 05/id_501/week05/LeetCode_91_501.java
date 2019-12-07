package homework.week05;

/**
 * 91. 解码方法
 * https://leetcode-cn.com/problems/decode-ways/
 * @author sintang
 * @date 2019-11-17
 */
public class LeetCode_91_501 {
    /**
     * 递归
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        return getAns(s, 0);
    }

    public int getAns(String s,int start){
        // 划分到最后直接返回
        if(start == s.length()){
            return 1;
        }
        //开头是 0,0 不对应任何字母，直接返回 0
        if (s.charAt(start) == '0') {
            return 0;
        }
        int ans1 = getAns(s,start + 1);
        int ans2 = 0;
        if(start < s.length() - 1){
            int ten = (s.charAt(start) - '0') * 10;
            int one = s.charAt(start + 1) - '0';
            if(ten + one <= 26){
                ans2 = getAns(s,start + 2);
            }
        }
        return ans1 + ans2;
    }

    /**
     * 动态规划
     * @param s
     * @return
     */
    public int numDecodings2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[len] = 1;
        if (s.charAt(len - 1) == '0') {
            dp[len - 1] = 0;
        } else {
            dp[len - 1] = 1;
        }
        for (int i = len - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
                continue;
            }
            if (Integer.valueOf(s.substring(i,i + 2)) <= 26) {
                dp[i] = dp[i + 1] + dp[i + 2];
            } else {
                dp[i] = dp[i + 1];
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        LeetCode_91_501 leetCode = new LeetCode_91_501();
        System.out.println(leetCode.numDecodings("12"));
    }
}
