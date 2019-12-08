import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-11-05 08:30
 **/

public class Leetcode_77_371 {

    public static void main(String[] args) {
        List<List<Integer>> results = combine1(4, 2);
        results.forEach(System.out::println);

    }

    /**
     * 仿解1:(回溯+减枝)
     *
     * @author Shaobo.Qian
     * @date 2019/11/9
     * @link https://leetcode-cn.com/problems/combinations/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-ma-/
     */
    public static List<List<Integer>> combine1(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();
        if (n <= 0 || n < k || k <= 0) {
            return results;
        }
        Stack<Integer> stack = new Stack<>();
        backtrace1(1, n, k, stack, results);
        return results;
    }

    private static void backtrace1(int start, int n, int k, Stack<Integer> stack, List<List<Integer>> results) {
        if (stack.size() == k) {
            results.add(new ArrayList<>(stack));
            return;
        }
        for (int i = start; i <= n - (k - stack.size()) + 1; i++) {//减枝,stack.size()已确定的元素个数
            stack.add(i);
            backtrace1(i + 1, n, k, stack, results);
            stack.pop();
        }
    }

    /**
     * 原解1:回溯(使用的数据结构)
     *
     * @author Shaobo.Qian
     * @date 2019/11/6
     */
    public static List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> results = new ArrayList<>();
        if (n <= 0 || k <= 0 || n < k) {
            return results;
        }
        List<Integer> subList = new ArrayList<>();
        backtrace(1, n, k, subList, results);
        return results;
    }

    /**
     * @param start   (1...n)个数中的第start个数
     * @param n       所有可能的数(1...n)
     * @param k       (由k个不同数组成的某一种结果)
     * @param subList 用来存储某一种组合的结果
     * @param results 所有的可能组合的结果
     */
    private static void backtrace(int start, int n, int k, List<Integer> subList, List<List<Integer>> results) {
        //1.递归出口(p)
        if (subList.size() == k) {
            results.add(new ArrayList<>(subList));
            return;
        }
        //2.处理当前层
        for (int i = start; i <= n; i++) {
            subList.add(i);
            //3.去下一层
            backtrace(i + 1, n, k, subList, results);
            //4.回溯
            subList.remove(subList.size() - 1);
        }
    }
}
