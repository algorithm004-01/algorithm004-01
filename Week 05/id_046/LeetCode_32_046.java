    public int longestValidParentheses(String s) {
        int res = 0;
        Stack<Integer> stack = new Stack();
        // 匹配初始括号对
        stack.push(-1);
        for(int i = 0;i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    res = Math.max(res,i-stack.peek());
                }
            }
        }
        return res;
    }