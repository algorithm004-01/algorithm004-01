public class LeetCode_338_CountingBits {
    public static void main(String[] args) {
        Solution solution = new LeetCode_338_CountingBits().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] countBits(int num) {

            int[] res = new int[num + 1];
            for (int i = 0; i <= num; i++) {
                res[i] = res[i >> 1] + (i & 1);
            }
            return res;
        }
    }

    class Solution1 {
        public int[] countBits(int num) {

            int[] res = new int[num + 1];
            for (int i = 0; i <= num; i++) {
                if ((i & 1) == 1) {
                    res[i] = res[i >> 1] + 1;
                } else {
                    res[i] = res[i >> 1];
                }
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}