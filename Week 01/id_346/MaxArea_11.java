package com.yiche.mapi;

/**
 * @auther: TKQ
 * @Title: MaxArea_11
 * @Copyright: Copyright (c) 2019
 * @Description:
 * @Company:
 * @Created: 2019-10-20 17:16
 */
public class MaxArea_11 {
    public int maxArea(int[] height) {
        int maxArea = 0;
        for (int leftIndex = 0, rightIndex = height.length - 1; leftIndex < rightIndex; ) {
            int currentArea = (rightIndex-leftIndex)*Math.min(height[leftIndex],height[rightIndex]);
            maxArea = Math.max(maxArea,currentArea);
            if(height[leftIndex]<=height[rightIndex]){
                leftIndex++;
            }else{
                rightIndex--;
            }
        }
        return maxArea;
    }
}

//runtime:4 ms
//memory:39.5 MB
