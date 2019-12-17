package sf.week8;

/**
 * Created by LynnSun on 2019/12/7.
 * 力扣题目地址：https://leetcode-cn.com/problems/reverse-string
 */
public class ReverseString {
    // 双指针
    public void reverseString(char[] s) {
        if (s == null || s.length < 2) {
            return;
        }
        int left = -1;
        int right = s.length;
        while (++left < --right) {
            char c = s[left];
            s[left] = s[right];
            s[right] = c;
        }

        return;
    }
}
