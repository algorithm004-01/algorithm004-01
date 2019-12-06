package homework.week01;

import java.util.Arrays;

/**
 * 88. 合并两个有序数组
 * https://leetcode-cn.com/problems/merge-sorted-array/
 */
public class MergeSortedArray{

    /**
     * 暴力法：
     * 合并后，排序
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    /**
     * 思路：
     * 双指针法
     * 获取到nums1元素最大索引p1，nums2最大索引p2，获取合并后元素最大索引p
     * nums1[p1] < nums2[p2] 把nums2[p2] 的值放到nums1[p] 上，然后进行下一轮循环
     * 最后结果[1,2,2,3,5,6]
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge2(int[] nums1, int m, int[] nums2, int n){
        // nums1最后面元素索引
        int p1 = m - 1;
        // nums1最后面元素索引
        int p2 = n - 1;

        // 合并后最后面元素索引
        int p = m + n - 1;

        while(p1 >= 0 && p2 >= 0){
            if(nums1[p1] < nums2[p2] ){
                nums1[p] = nums2[p2];
                p2--;
                
            }else{
                nums1[p] = nums1[p1];
                p1--;
            }
            p--;
        }
        // 当前
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0}; 
        int[] nums2 = new int[]{2,5,6};
        // merge(nums1, 3, nums2, 3);
        merge2(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }

}