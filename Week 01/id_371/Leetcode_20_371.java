import java.util.Stack;

/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-11-10 16:07
 **/

public class Leetcode_20_371 {

    public static void main(String[] args) {
//        System.out.println(isValid2("()"));
//        System.out.println(isValid2("()[]{}"));
//        System.out.println(isValid2("(]"));
//        System.out.println(isValid2("([)]"));
//        System.out.println(isValid2("("));
        System.out.println(isValid1("[])"));

    }

    /**
     * 原解1:stack+字符串
     * @author Shaobo.Qian
     * @date 2019/11/10
     */
    public static boolean isValid1(String s) {
        if(s.isEmpty()) return true;
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String singleStr = String.valueOf(s.charAt(i));
            if ("{".equals(singleStr)) {
                stack.push("}");
            } else if ("[".equals(singleStr)) {
                stack.push("]");
            } else if ("(".equals(singleStr)) {
                stack.push(")");
            } else {
                if(stack.isEmpty()) return false;
                String currStr = stack.pop();
                if (!currStr.equals(singleStr)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
