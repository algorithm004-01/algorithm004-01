/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-12-05 08:37
 **/

public class Leetcode_58_371 {
    public static void main(String[] args) {
        String str = "Hello World";
//        String str = "  A";
        int len = lengthOfLastWord1(str);
        System.out.println("len = " + len);
    }

    /**
     * 原解1:正则
     * @author Shaobo.Qian
     * @date 2019/12/5
     */
    public static int lengthOfLastWord(String s) {
        //1.字符串-->单词数组
        String[] strArr = s.split("( )+");
        int len = strArr.length;
        return len > 0 ? strArr[len - 1].length() : 0;
    }

    /**
     * 防解1:
     * @author Shaobo.Qian
     * @date 2019/12/5
     * @link https://leetcode-cn.com/problems/length-of-last-word/solution/hua-jie-suan-fa-58-zui-hou-yi-ge-dan-ci-de-chang-d/
     */
    public static int lengthOfLastWord1(String s) {
        int endIndex = s.length() - 1;
        while (endIndex>=0 && s.charAt(endIndex) == ' ') endIndex--;
        if (endIndex < 0) return 0;
        int wordIndex = endIndex;
        while (wordIndex>=0 && s.charAt(wordIndex) != ' ') wordIndex--;

        return endIndex - wordIndex;
    }
}
