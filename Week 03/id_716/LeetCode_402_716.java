// https://leetcode-cn.com/problems/remove-k-digits
// 移掉K位数字

public class LeetCode_402_716 {
    public String removeKdigits(String num, int k) {
        if (k >= num.length()) return "0";

        char[] stack = new char[num.length()];
        int sPos = 0;

        for (char curr : num.toCharArray()) {
            // 移动到新的字符上时，都去找当前的最大值，移除掉
            while (k > 0 && sPos > 0 && stack[sPos] > curr) {
                sPos--;
                k--;
            }

            // 如果第一个位置是0的话，直接丢弃
            if (sPos != 0 || curr != '0') {
                stack[sPos++] = curr;
            }
        }

        String res = new String(stack, 0, sPos - k);
        return res.isEmpty() ? "0" : res;
    }
}