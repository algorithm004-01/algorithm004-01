
// https://leetcode-cn.com/problems/valid-perfect-square
// 有效的完全平方数

public class LeetCode_367_716 {
    // 1. 暴力求解
    public boolean isPerfectSquare1(int num) {
        for (int i = 1; i <= (num + 1)/2; i++) {
            if (i == num/i && i * i == num) {
                return true;
            }
        }
        return false;
    }

    // 2. 二分搜索
    public boolean isPerfectSquare2(int num) {
        int l = 1, r = (num >> 1) + 1;
        while (l <= r) {
            int m = l + (r - l) / 2;

            // 可以最大程度的防止溢出
            if (m == num/m && m * m == num) return true;

            if (m > num/m) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return false;
    }
    // 同样，这个题目可以利用 69 题，在最后判断 r*r == num ?

    // 3. 等差数列
    public boolean isPerfectSquare3(int num) {
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }

    // 4. 牛顿法
    public boolean isPerfectSquare4(int num) {
        long r = num;
        while (r > num/r) {
            r = (r + num/r) / 2;
        }
        int rs = (int) r;
        return rs * rs == num;
    }
}