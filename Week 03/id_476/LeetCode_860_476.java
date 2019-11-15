public class LeetCode_860_LemonadeChange {
    public static void main(String[] args) {
        Solution solution = new LeetCode_860_LemonadeChange().new Solution();
    }


    class Solution {
        public boolean lemonadeChange(int[] bills) {
            int five = 0;
            int ten = 0;
            for (int bill : bills) {
                if (bill == 5) {
                    five++;
                } else if (bill == 10) {
                    five--;
                    ten++;
                } else if (ten > 0) {
                    ten--;
                    five--;
                } else {
                    five -= 3;
                }
                if (five < 0) return false;
            }
            return true;
        }
    }

}