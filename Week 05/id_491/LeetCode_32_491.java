class Solution {
    public int longestValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        int result = 0;
        int tempResult = 0;
        int tempEnd = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                    tempResult += 2;
                } else {
                    if (tempResult > result) {
                        result = tempResult;
                    }
                    tempResult = 0;
                    tempEnd = i + 1;
                }
            }
        }

        if(!stack.isEmpty()) {
            tempResult = 0;
            stack.clear();
            for (int i = s.length() - 1; i >= tempEnd; i--) {
                if (s.charAt(i) == ')') {
                    stack.push(')');
                } else {
                    if (!stack.isEmpty()) {
                        stack.pop();
                        tempResult += 2;
                    } else {
                        if (tempResult > result) {
                            result = tempResult;
                        }
                        tempResult = 0;
                    }
                }
            }

            if (tempResult > result) {
                result = tempResult;
            }
        } else {
            if (tempResult > result) {
                result = tempResult;
            }
        }

        return result;
    }
}
