class LeetCode_231{
    public boolean isPowerOfTwo(int n) {
        //n & (n-1) ��һ��������������Ҫǿ������ת��
       return n > 0 && (int)(n & (n - 1)) == 0;
    }
}