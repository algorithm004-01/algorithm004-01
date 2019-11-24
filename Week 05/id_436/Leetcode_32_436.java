class Solution {
    public int longestValidParentheses(String s) {
        int result = 0; int start = 0; int n = s.length();
        Stack<Integer> stack = new Stack<Integer>();
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') 
                stack.push(i);
            else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    start = i + 1;
                }
                else {
                    stack.pop();
                    if (stack.isEmpty()) 
                        result = Math.max(result,i - start + 1);
                    else 
                        result = Math.max(result, i - (stack.peek() + 1) + 1);
                }
            }
        }       
        return result;
    }
}
