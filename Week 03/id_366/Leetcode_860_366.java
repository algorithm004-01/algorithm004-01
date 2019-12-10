/*
 * @lc app=leetcode.cn id=860 lang=java
 *
 * [860] 柠檬水找零
 */

// @lc code=start
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten =0;
        for (int i:bills) {
            if (i == 5) { //顾客付5元
                five++;
            }else if (i == 10) { //顾客付10元
                ten++;
                five--;
            } else if (ten > 0) { //顾客付20元,并且我们有10块零钱可以找零
                ten--;
                five--;
            } else { //顾客付20元,但是我们没有10块零钱可以找零
                five -= 3;
            }
            if (five < 0) return false;
        }
        return true;
    }
}
// @lc code=end

