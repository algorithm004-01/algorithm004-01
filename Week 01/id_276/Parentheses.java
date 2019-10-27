public class Parentheses {
    //栈的放法实现，时间复杂度O(n)
    public boolean isValidParanthese (char[] str) {
        if (str == null) {
            return false;
        }

        Deque<Character> stack = new LinkedList<>();

        int i = 0;
        while (i < str.length) {
            if (str[i] == '(') {
                stack.push(')');
            } else if (str[i] == '[') {
                stack.push(']');
            } else if (str[i] == '{') {
                stack.push('}');
            } else if (!stack.isEmpty()&&str[i] == stack.peekFirst()) {
                stack.pop();
            } else {
                stack.push(str[i]);
            }
            i ++;
        }
        return stack.isEmpty();
    }

    //暴力法：从左往右走，把匹配的位置换成""
    public static boolean isValid (String s) {
        int i = 0;
        while (i < s.length()) {
            String temp = s.replace("()","");
             temp = s.replace("[]","");
             temp = s.replace("{}","");
             System.out.println(temp);
             if (s.equals("")) {
                 return true;
             }
             if (s.equals(temp)) {
                 return false;
             }
             s = temp;
             i ++;
        }
        return s.equals("");
    }
  /*  public static boolean isValid (String s) {
        if (s == null || s == "")return false;

        Deque<Character> stack = new LinkedList<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }

        return stack.isEmpty();
    }*/
  public static void main(String[] args) {
      String s = "()";
      System.out.println(isValid(s));
  }
}
