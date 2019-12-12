package sf.week8;

/**
 * Created by LynnSun on 2019/12/7.
 * 力扣题目地址：https://leetcode-cn.com/problems/to-lower-case
 */
public class ToLowerCase {
    // Java 最好的解法
    public String toLowerCase(String str) {
        char[] st = new char[str.length()];
        char c;
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            if (c >= 65 && c <= 90) {
                c = (char) (c + 32);
            }
            st[i] = c;
        }
        return new String(st);
    }
}
