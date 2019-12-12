package homework.week08;

/**
 * 91. 解码方法
 * https://leetcode-cn.com/problems/decode-ways/
 * @author: sintang
 * @date: 2019-12-08
 */
public class LeetCode_91_501 {

    public int numDecodings(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        return digui(s,0);
    }

    public int numDecodings2(String s) {
        int length = s.length();
        int[] dp = new int[length + 1];
        dp[length] = 1;
        if(s.charAt(length - 1) != '0'){
            dp[length - 1] = 1;
        }
        for(int i = length - 2;i>=0;i--){
            if(s.charAt(i) == '0'){
                continue;
            }
            int ans1 = dp[i + 1];
            int ans2 = 0;
            int ten = (s.charAt(i) - '0' )* 10;
            int one = s.charAt(i + 1) - '0';
            if(ten + one <= 26){
                ans2 = dp[i + 2];
            }
            dp[i] = ans1 + ans2;
        }
        return dp[0];
    }


    public int digui(String str,int start){
        if(str.length() == start){
            return 1;
        }
        // 不能已0开始
        if(str.charAt(start) == '0'){
            return 0;
        }
        int ans1 = digui(str,start + 1);
        int ans2 = 0;
        if(start < str.length() - 1){
            int ten = (str.charAt(start) - '0') * 10;
            int one = str.charAt(start + 1) - '0';
            if(ten + one <= 26){
                ans2 = digui(str,start + 2);
            }
        }
        return ans1 + ans2;
    }
}
