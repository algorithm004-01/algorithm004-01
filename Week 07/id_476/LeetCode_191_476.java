public class LeetCode_191_NumberOf1Bits {
    public static void main(String[] args) {
        Solution solution = new LeetCode_191_NumberOf1Bits().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {

            int res = 0;
            while (n != 0) {
                res += (n & 1);
                n >>>= 1;
            }
            return res;
        }
    }

    public class Solution2 {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {

            int res = 0;
            while (n != 0) {
                res++;
                n &= (n - 1);
            }
            return res;
        }
    }

    public class Solution1 {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {

            int res = 0;
            int mask = 1;
            for (int i = 0; i < 32; i++) {
                if ((n & mask) != 0) {
                    res++;
                }
                mask <<= 1;
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}