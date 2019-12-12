
// https://leetcode-cn.com/problems/lemonade-change
// 柠檬水找零

public class LeetCode_860_716 {

    // 利用贪心算法实现
    public boolean lemonadeChange(int[] bills) {
        int fiveCnt = 0, tenCnt = 0;
        for (int bill : bills) {
            if (bill == 5) fiveCnt++;
            else if (bill == 10) { fiveCnt--; tenCnt++; }
            else if (tenCnt > 0) { tenCnt--; fiveCnt--; }
            else fiveCnt -= 3;

            if (fiveCnt < 0) return false;
        }
        return true;
    }
}
