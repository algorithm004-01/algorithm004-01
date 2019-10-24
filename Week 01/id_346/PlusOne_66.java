package com.yiche.mapi.cargoods;

/**
 * @auther: TKQ
 * @Title: PlusOne_66
 * @Copyright: Copyright (c) 2019
 * @Description:
 * @Company:
 * @Created: 2019-10-20 17:24
 */
public class PlusOne_66 {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        for(int i = len-1;i>=0;i--){
            digits[i]++;
            digits[i]= digits[i]%10;
            if(digits[i]!=0){
                return digits;
            }
        }
        int[] result = new int[len+1];
        result[0] = 1;
        return result;
    }
}
//runtime:0 ms
//memory:35 MB
