import java.util.ArrayList;
import java.util.List;

/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-11-05 08:28
 **/

public class Leetcode_17_371 {
    public static void main(String[] args) {
        String digits = "23";
        List<String> res = letterCombinations(digits);
        res.stream().forEach(System.out::println);

    }

    /**
     * 原解1:(回溯)
     *
     * @author Shaobo.Qian
     * @date 2019/11/5
     */
    public static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if ("".equals(digits)) {
            return list;
        }
        String[] dicts = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        char[] sources = digits.toCharArray();
        char[] targets = new char[digits.length()];
        backtrace(sources, dicts, list, 0, targets);
        return list;
    }

    private static void backtrace(char[] sources, String[] dicts, List<String> list, int startIndex, char[] targets) {
        //1.递归出口
        if (startIndex == sources.length) {
            list.add(String.valueOf(targets));
            return;
        }

        //2.处理当前层
        char source = sources[startIndex];
        String dict = dicts[Integer.parseInt(String.valueOf(source))];
        for (int i = 0; i < dict.length(); i++) {
            char target = dict.charAt(i);
            targets[startIndex] = target;//每次循环,之前的值会被覆盖,相当于回溯
            //3.去下一层
            backtrace(sources, dicts, list, startIndex + 1, targets);
        }
    }

}
