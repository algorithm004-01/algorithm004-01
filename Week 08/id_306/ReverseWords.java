package sf.week8;

/**
 * Created by LynnSun on 2019/12/7.
 * 力扣题目地址：https://leetcode-cn.com/problems/reverse-words-in-a-string
 */
public class ReverseWords {
    // O(1)空间复杂度 用char数组完成
    public String reverseWords(String s) {
        if (null == s || s.length() == 0)
            return "";
        final char[] c = s.toCharArray();
        final int len = c.length;
        int i = len - 1;

        while (i >= 0 && c[i] == ' ') i--;

        int left = i + 1;
        int right = i + 1;
        StringBuffer sb = new StringBuffer(i + 1);


        for (; i >= 0; i--) {
            if (c[i] == ' ') {
                if (right != left) sb.append(c, left, right - left).append(" ");
                left = i;
                right = i;
                continue;
            }
            left = i;
        }
        if (right != left)
            return sb.append(c, left, right - left).toString();
        return sb.length() > 0 ? sb.substring(0, sb.length() - 1) : "";
    }
}
