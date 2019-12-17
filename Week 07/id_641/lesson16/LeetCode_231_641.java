package vip.ruoyun.week7.lesson16;

public class LeetCode_231_641 {

    //2的幂数的数字的二进制有且只有一个1，其余均是0
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}

