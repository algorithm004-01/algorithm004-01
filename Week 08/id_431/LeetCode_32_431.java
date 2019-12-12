package hard;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author 潘磊明
 * @date 2019/11/15
 */
public class LongestValidParentheses {

//    public int longestValidParentheses(String s) {
//        if (s.length() <= 1) return 0;
//        /**
//         * 状态方程，存储当前有效括号的最大距离
//         */
//        int[] dp = new int[s.length()];
//        char[] array = s.toCharArray();
//        int max = 0;
//        dp[0] = 0;
//        for (int i = 1; i < array.length; i++) {
//            if (array[i] == ')') {
//                if (array[i - 1] == '(') {
//                    dp[i] = i >= 2 ? dp[i] = dp[i - 2] + 2 : 2;
//                }else {
//                    if (i - dp[i - 1] - 1 >= 0
//                            && array[i - dp[i - 1] - 1] == '(') {
//                        //还需判断前面的有效括号能不能组合在一起，例如()(())
//                        dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2 > 0 ? dp[i - dp[i - 1] - 2] : 0);
//                    }
//                }
//                max = Math.max(max, dp[i]);
//            }
//        }
//        return max;
//    }

    /**
     * 使用栈
     * @param s
     * @return
     */
//    public int longestValidParentheses(String s) {
//        Deque<Integer> deque = new LinkedList<>();
//        char[] arr = s.toCharArray();
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] == ')' && !deque.isEmpty() && arr[deque.getFirst()] == '(') {
//                deque.removeFirst();
//            } else {
//                deque.addFirst(i);
//            }
//        }
//        if (deque.isEmpty()) return s.length();
//        int a = s.length() - 1, max = 0;
//        while (!deque.isEmpty()) {
//            int tmp = deque.removeFirst();
//            max = Math.max(a - tmp, max);
//            a = tmp - 1;
//        }
//        max = Math.max(a, max);
//        return max;
//    }

//    public int longestValidParentheses(String s) {
//        char[] array = s.toCharArray();
//        if (array.length < 2) return 0;
//        int[] dp = new int[array.length];
//        int max = 0;
//        dp[0] = 0;
//        for (int i = 1; i < array.length; i++) {
//            if (array[i] == ')') {
//                if (array[i - 1] == '(') {
//                    dp[i] = i - 2 >= 0 ? dp[i - 2] + 2 : 2;
//                }
//                else {
//                    //判断前方是否有多余的(
//                    int ind = i - dp[i - 1] - 1;
//                    if (ind >= 0 && array[ind] == '(') {
//                        dp[i] = dp[i - 1] + 2 + (ind - 1 > 0 ? dp[ind - 1] : 0);
//                    }
//                }
//            }
//            max = Math.max(max, dp[i]);
//        }
//        return max;
//    }

    public int longestValidParentheses(String s) {
        char[] array = s.toCharArray();
        if (array.length < 2) return 0;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
            if (!deque.isEmpty() && array[i] == ')' && array[deque.getLast()] == '(') deque.removeLast();
            else deque.addLast(i);
        }
        if (deque.isEmpty()) return array.length;
        int max = 0;
        int first = 0;
        deque.addLast(array.length);
        while (!deque.isEmpty()) {
            int tmp = deque.removeFirst();
            max = Math.max(tmp - first - 1, max);
            first = tmp;
        }
        return max;
    }
}
