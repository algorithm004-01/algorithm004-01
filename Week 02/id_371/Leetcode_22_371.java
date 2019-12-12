import java.util.ArrayList;
import java.util.List;

/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-10-27 06:52
 **/

public class Leetcode_22_371 {
    public static void main(String[] args) {
        List<String> result = generateParenthesis1(3);
        result.stream().forEach(System.out::println);

    }

    /**
     * 仿解1:回溯法
     * @param n
     * @return
     */
    public static List<String> generateParenthesis1(int n) {
        List<String> result = new ArrayList<>();
        backtrace(result, "", 0, 0, n);
        return result;
    }

    /**
     * 仿解1:回溯法
     * @param result 结果容器
     * @param str 单个路径的收集容器
     * @param open 左括号个数
     * @param close 右括号个数
     * @param maxLen 左右括号个数的限制
     */
    private static void backtrace(List<String> result, String str, int open, int close, int maxLen) {
        //1.递归出口
        if (str.length() == maxLen * 2) {
            result.add(str);
            return;
        }
        //2.处理当前层
        //3.带上参数,去下一层
        //3.1如果左括号没超出限制
        if (open < maxLen) backtrace(result, str + "(", open + 1, close, maxLen);
        //3.2如果要括号<左括号,继续当前栈继续执行该条语句
        if (close < open) backtrace(result, str + ")", open, close + 1, maxLen);

    }

    /**
     * 原解1:递归(未解出)
     */
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        return recur(0, n, result);
    }

    private static List<String> recur(int i, int n, List<String> result) {
        //1.递归出口
        if (i < 2 * n) {
            //2.处理当前层
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            //3.带上参数,去下一层

        }

        //4.清理当前层
        return null;
    }

}
