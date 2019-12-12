package sf.week8;

/**
 * Created by LynnSun on 2019/12/8.
 * 力扣题目地址：https://leetcode-cn.com/problems/reverse-words-in-a-string-iii
 */
public class ReverseWordsIII {

    public String reverseWords(String s) {
        String words[] = s.split(" ");
        StringBuilder res=new StringBuilder();
        for (String word: words)
            res.append(new StringBuffer(word).reverse().toString() + " ");
        return res.toString().trim();
    }
    /**
     * 官方题解
     * @param input
     * @return
     */
    public String reverseWords1(String input) {
        final StringBuilder result = new StringBuilder();
        final StringBuilder word = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != ' ') {
                word.append(input.charAt(i));
            } else {
                result.append(word.reverse());
                result.append(" ");
                word.setLength(0);
            }
        }
        result.append(word.reverse());
        return result.toString();
    }
}
