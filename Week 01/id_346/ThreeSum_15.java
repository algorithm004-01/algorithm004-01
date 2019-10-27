package com.yiche.mapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @auther: TKQ
 * @Title: ThreeSum_15
 * @Copyright: Copyright (c) 2019
 * @Description:
 * @Company:
 * @Created: 2019-10-20 17:21
 */
public class ThreeSum_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length-2; i++) {
            if(nums[i] > 0){ break;}
            if(i>0&&nums[i]==nums[i-1]){continue;}
            for(int l = i+1,r = nums.length-1;l<r;){
                int sum = nums[i] + nums[l] + nums[r];
                if(sum >0){
                    r--;
                }else if(sum <0){
                    l++;
                }else{
                    result.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    while(l<r&&nums[r]==nums[r-1]){r--;}
                    while(l<r&&nums[l]==nums[l+1]){l++;}
                    r--;l++;
                }
            }
        }
        return result;
    }
}
//runtime:32 ms
//memory:48.1 MB
