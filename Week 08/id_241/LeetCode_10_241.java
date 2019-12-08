import java.util.*;
/**
 * 正则表达式匹配
 */
class Solution {
    private Boolean[][] dp;

    public boolean isMatch(String s, String p) {
        dp = new Boolean[s.length()][p.length()];
        return isMatchHelper(0, 0, s, p);
    }

    private boolean isMatchHelper(int i, int j, String s, String p) {
        if (j == p.length()) return i == s.length(); //如果正则匹配结束后，字符串也应该匹配完毕
        if (i < s.length() && dp[i][j] != null) return dp[i][j]; //使用数组缓存已经算过的点
        boolean ans;
        //这里需要先算第一个字符是否匹配的，而不能放到判断子句中，否则会影响结果
        //也就是，后面的判断，只要传递 i + 1，就要判断当前的 first
        boolean first = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        //如果字符的第二个是*号
        if (p.length() - j >= 2 && p.charAt(j + 1) == '*')
            //两种情况，一个是匹配0 个，则忽略正则的*号和之前一个字符。一个是匹配多个，则不断的移动 s
            //这里需要将匹配 0 个情况放在判断的开头，这样当 i 溢出时，会通过 j+2的行为，让第一行判断终止递归。否则 i 将无限循环.
            ans = isMatchHelper(i, j + 2, s, p) || (first && isMatchHelper(i + 1, j, s, p));
        else
            //这里就是没有*号，则都往后移动一位。这里需要用 first，如果为 false，就不会判断后面了。
            ans = first && isMatchHelper(i + 1, j + 1, s, p);
        //由于 i 会有溢出的可能，所以每次二维数组操作，需要判断 i 的界限
        if (i < s.length()) dp[i][j] = ans;
        return ans;
    }
}