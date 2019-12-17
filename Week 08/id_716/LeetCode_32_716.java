import java.util.Deque;
import java.util.LinkedList;

public class LeetCode_32_716 {
    public int longestValidParentheses(String s) {
        int maxLen = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.addFirst(-1);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.addFirst(i);
            } else { // )
                stack.removeFirst();
                if (stack.isEmpty()) {
                    stack.addFirst(i);
                } else {
                    maxLen = Math.max(maxLen, i - stack.peekFirst());
                }
            }
        }
        return maxLen;
    }
}