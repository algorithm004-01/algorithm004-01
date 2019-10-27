package com.yiche;

/**
 * @auther: TKQ
 * @Title: ReverseString_344
 * @Copyright: Copyright (c) 2019
 * @Description:
 * @Company:
 * @Created: 2019-10-20 17:32
 */
public class ReverseString_344 {
    public void reverseString(char[] s) {
        if(s==null || s.length<2){
            return;
        }
        int l = -1,r=s.length;
        while(++l<--r){
            char temp = s[l];
            s[l]= s[r];
            s[r] = temp;
        }
    }
}
//runtime:1 ms
//memory:51.3 MB
