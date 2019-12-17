public class LeetCode_8_StringToIntegerAtoi {
    public static void main(String[] args) {
        Solution solution = new LeetCode_8_StringToIntegerAtoi().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int myAtoi(String str) {

            if (str == null || str.length() == 0) return 0;

            int i = 0;
            while (i < str.length() && str.charAt(i) == ' ') {
                i++;
            }
            if (i == str.length()) return 0;

            boolean negative = false;
            if (str.charAt(i) == '-') {
                negative = true;
                i++;
            } else if (str.charAt(i) == '+') {
                i++;
            }

            int res = 0;
            for (int j = i; j < str.length(); j++) {
                char ch = str.charAt(j);
                if (ch < '0' || ch > '9') {
                    break;
                }
                if (!negative && res > Integer.MAX_VALUE / 10) {
                    res = Integer.MAX_VALUE;
                    break;
                } else if (!negative && res == Integer.MAX_VALUE / 10 && (ch - '0') > Integer.MAX_VALUE % 10) {
                    res = Integer.MAX_VALUE;
                    break;
                } else if (negative && (0 - res) < Integer.MIN_VALUE / 10) {
                    res = Integer.MIN_VALUE;
                    break;
                } else if (negative && (0 - res) == Integer.MIN_VALUE / 10 && ('0' - ch) < Integer.MIN_VALUE % 10) {
                    res = Integer.MIN_VALUE;
                    break;
                }
                res = res * 10 + ch - '0';
            }

            return negative ? -res : res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}