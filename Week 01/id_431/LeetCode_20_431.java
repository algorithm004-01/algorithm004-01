package simple;

import java.util.Stack;

/**
 * @author 潘磊明
 * @date 2019/10/22
 */
public class ValidParentheses {
    /**
     * 使用栈
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String tmp = s.substring(i, i + 1);
            if (stack.empty()) {
                stack.push(tmp);
            }else {
               if (isValid(stack.peek(), tmp)){
                   stack.pop();
               }else {
                   stack.push(tmp);
               }
            }
        }
        return stack.empty();
    }

    boolean isValid(String left, String right){
        if("(".equals(left) && ")".equals(right)){
            return true;
        }else if ("[".equals(left) && "]".equals(right)) {
            return true;
        }else if ("{".equals(left) && "}".equals(right)) {
            return true;
        }
        return false;
    }
}
