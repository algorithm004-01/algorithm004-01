package com.yiche;

/**
 * @auther: TKQ
 * @Title: Merge_88
 * @Copyright: Copyright (c) 2019
 * @Description:
 * @Company:
 * @Created: 2019-10-20 17:27
 */
public class Merge_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;int j = n-1;int k = m+n-1;
        while(i>=0&&j>=0){
            if(nums1[i]<=nums2[j]){
                nums1[k--]= nums2[j--];
            }else{
                nums1[k--]= nums1[i--];
            }
        }
        while(j>=0){
            nums1[k--] = nums2[j--];
        }
    }
}
//runtime:0 ms
//memory:36.1 MB
