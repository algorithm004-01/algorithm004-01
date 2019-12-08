import java.util.Stack;

public class Brackets32 {
    public static void main(String[] args) {
        Brackets32 brackets32 = new Brackets32();
        System.out.println(brackets32.longestValidParentheses("("));
        System.out.println(brackets32.longestValidParentheses2(""));
        System.out.println(brackets32.longestValidParentheses2("("));
    }

    // 1. brutal force (O(n^2))
    public int longestValidParentheses(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); ++i) {
            for (int j = i + 2; j <= s.length(); j += 2) {
                if (isValid(s.substring(i, j))) {
                    max = Math.max(max, j - i);
                }
            }
        }
        return max;
    }

    private boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else if (!stack.isEmpty() && stack.peek() == '(') {
                // s.charAt(i) ==')'
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    // 2. DP (O(n))
    public int longestValidParentheses2(String s) {
        int max = 0;
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] >= 1) {
                    if (s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = dp[i - 1] + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                    }
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }

    // 3. Stack (O(n)但由于出入栈操作导致比DP慢)
    public int longestValidParentheses3(String s) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }

    // 4. Scan
    public int longestValidParentheses4(String s) {
        int l = 0, r = 0, max = 0;
        // scan left to right
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                l++;
            } else {
                r++;
            }
            if (l == r) {
                max = Math.max(max, l + r);
            } else if (r > l) {
                l = r = 0;
            }
        }
        l = r = 0;
        // scan right to left
        for (int i = s.length() - 1; i >= 0; --i) {
            if (s.charAt(i) == '(') {
                l++;
            } else {
                r++;
            }
            if (l == r) {
                max = Math.max(max, l + r);
            } else if (l > r) {
                l = r = 0;
            }
        }
        return max;
    }
}