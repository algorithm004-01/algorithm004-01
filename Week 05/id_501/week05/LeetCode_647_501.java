package homework.week05;

/**
 * 647. 回文子串
 * https://leetcode-cn.com/problems/palindromic-substrings/
 * @author sintang
 * @date 2019-11-17
 */
public class LeetCode_647_501 {

    public int countSubstrings(String s) {
        int result  = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0 ; i--) {
            for(int j = i;j < s.length() ; j ++){
                if(i == j){
                    dp[i][j] = true;
                }else{
                    dp[i][j] = s.charAt(i) == s.charAt(j) && (j <= i + 1 || dp[i +1][j - 1]);
                }
                if(dp[i][j]){
                    result ++;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {

    }
}
