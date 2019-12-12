package com.sslz.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 求众数
 */
public class LeetCode_169 {
    public int majorityElement(int[] mums) {
        int count = 0;
        Map<Integer,Integer> map  = new HashMap<>();
        for(int i =0;i<mums.length;i++){
            if(map.containsKey(mums[i])){
                int value = (int) map.get(mums[i]);
                map.put(mums[i],value+1);
            }else{
                map.put(mums[i],1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue()>mums.length/2){
                count=entry.getKey();
            }
        }
        return count ;
    }


}
