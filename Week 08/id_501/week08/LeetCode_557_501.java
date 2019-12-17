package homework.week08;

/**
 * 557. 反转字符串中的单词 III
 * https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
 * @author: sintang
 * @date: 2019-12-08
 */
public class LeetCode_557_501 {
    public static String reverseWords(String s) {
        char[] chars = new char[s.length()];
        int j = 0;
        String[] arr = s.split(" ");
        for(String str : arr){
            for (int i = str.length() - 1; i >= 0 ; i--) {
                chars[j] = str.charAt(i);
                j ++;
            }
            if(j < s.length()){
                chars[j] = ' ';
                j++;
            }

        }

        return new String(chars);
    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords(s));
    }
}
