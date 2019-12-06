// 一开始没有考虑负数的情况，只做了模余判断
class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) return false;
        for(;n >= 2;){
            if(n % 2 == 1) return false;
            n = n / 2;
        }
        return true;
    }
}

// 题解学习到的解法，思维值得学习
class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}