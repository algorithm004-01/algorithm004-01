package com.first;

public class Fibolacci {
    //0、1、1、2、3、5、8、13、21
    protected int getFibolacciNum(int n) {
        int fib = 0;
        int pre = 0;
        int next = 1;

        if(n<2) return n;
        if(n>=2) {
            for(long i = 0;i<=n-2;i++) {
                fib = pre+next;
                pre = next;
                next = fib;
            }
        }
        return fib;
    }
}
