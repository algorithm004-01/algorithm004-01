package medium;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author 潘磊明
 * @date 2019/12/11
 */
public class StringToIntegerAtoi {
    public int myAtoi(String str) {
        String s = str.trim();
        char[] chars = s.toCharArray();
        if (chars.length == 0) return 0;
        Deque<Character> deque = new LinkedList<>();
        //判断首字母
        if (!isEffective(chars[0])) return 0;
        deque.addLast(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') deque.addLast(chars[i]);
            else {
                break;
            }
        }
        long num = 0L;
        boolean flag = true; //是正还是负
        //初始化
        char first = deque.removeFirst();
        if (first == '-') flag = false;
        else if (first >= '0' && first <= '9') num += (first - '0') * Math.pow(10, deque.size());
        while (!deque.isEmpty()) {
            first = deque.removeFirst();
            if (flag) {
                num += (first - '0') * Math.pow(10, deque.size());
                if (num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            }
            else {
                num -= (first - '0') * Math.pow(10, deque.size());
                if (num < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            }
        }
        return (int)num;
    }

    private boolean isEffective(char c) {
        if (c == '+' || c == '-' || (c >= '0' && c <= '9')) return true;
        return false;
    }
}
