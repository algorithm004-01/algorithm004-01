package sf.week8;

/**
 * Created by LynnSun on 2019/12/7.
 * 力扣题目地址：https://leetcode-cn.com/problems/length-of-last-word
 */
public class LengthOfLastWord {
    // 常规解法
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int start = s.lastIndexOf(" ") + 1;
        return s.substring(start).length();
    }
    // 另一种解法
    public int lengthOfLastWordOther(String s) {
        int end = s.length() - 1;
        while(end >= 0 && s.charAt(end) == ' ') end--;
        if(end < 0) return 0;
        int start = end;
        while(start >= 0 && s.charAt(start) != ' ') start--;
        return end - start;
    }
}
