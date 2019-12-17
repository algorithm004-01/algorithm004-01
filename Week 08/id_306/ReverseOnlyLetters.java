package sf.week8;

/**
 * Created by LynnSun on 2019/12/7.
 * 力扣题目地址：https://leetcode-cn.com/problems/reverse-only-letters
 */
public class ReverseOnlyLetters {
    // 最好的解法
    public String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i < j) {
            while (i < j && (chars[i] < 'A' || (chars[i] > 'Z' && chars[i] < 'a') || chars[i] > 'z')) i++;
            while (i < j && (chars[j] < 'A' || (chars[j] > 'Z' && chars[j] < 'a') || chars[j] > 'z')) j--;
            if(i < j) {
                chars[i] ^= chars[j];
                chars[j] ^= chars[i];
                chars[i++] ^= chars[j--];
            }
        }
        return String.valueOf(chars);
    }

    // 反转指针
    public String reverseOnlyLetters1(String S) {
        StringBuilder ans = new StringBuilder();
        int j = S.length() - 1;
        for (int i = 0; i < S.length(); ++i) {
            if (Character.isLetter(S.charAt(i))) {
                while (!Character.isLetter(S.charAt(j)))
                    j--;
                ans.append(S.charAt(j--));
            } else {
                ans.append(S.charAt(i));
            }
        }

        return ans.toString();
    }
}
