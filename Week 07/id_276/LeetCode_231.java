class LeetCode_231{
    public boolean isPowerOfTwo(int n) {
        //n & (n-1) 是一个二进制数，需要强制类型转换
       return n > 0 && (int)(n & (n - 1)) == 0;
    }
}