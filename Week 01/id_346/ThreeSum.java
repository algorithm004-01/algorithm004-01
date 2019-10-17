package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @auther: TKQ
 * @Title: ThreeSum
 * @Copyright: Copyright (c) 2019
 * @Description:
 * @Company:
 * @Created: 2019-10-17 23:58
 */
public class ThreeSum {
    public static void main(String[] args) {
        List<List<Integer>> lists = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(lists);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length-2; i++) {
            if(nums[i] > 0){break;}
            if(i>0&&nums[i]==nums[i-1]){continue;}
            for(int l = i+1,r = nums.length-1;l<r;){
                int sum = nums[i] + nums[l] + nums[r];
                if(sum >0){
                    r--;
                }else if(sum <0){
                    l++;
                }else{
                    result.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    do{r--;}while(l<r&&nums[r]==nums[r-1]);
                    do{l++;}while(l<r&&nums[l]==nums[l+1]);
                }
            }
        }
        return result;
    }

}
