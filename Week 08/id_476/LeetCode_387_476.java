public class LeetCode_387_FirstUniqueCharacterInAString {
    public static void main(String[] args) {
        Solution solution = new LeetCode_387_FirstUniqueCharacterInAString().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int firstUniqChar(String s) {

            int res = Integer.MAX_VALUE;
            for (char ch = 'a'; ch <= 'z'; ch++) {
                int index = s.indexOf(ch);
                if (index != -1 && index == s.lastIndexOf(ch)) {
                    res = Math.min(res, index);
                }
            }
            return res == Integer.MAX_VALUE ? -1 : res;
        }
    }
    class Solution1 {
        public int firstUniqChar(String s) {

            if (s == null || s.length() == 0) return -1;

            Map<Character, Integer> counter = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                counter.put(ch, counter.getOrDefault(ch, 0) + 1);
            }

            for (int i = 0; i < s.length(); i++) {
                if (counter.get(s.charAt(i)) == 1) {
                    return i;
                }
            }
            return -1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}