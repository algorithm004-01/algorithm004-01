package Week1;

import java.util.Arrays;

public class Lettcode_088 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        merge(nums1,m,nums2,n);
        System.out.println(Arrays.toString(nums1));
    }

    /**
     * 用新的数组辅助
     * 看了题解后发现从后往前不需要辅助数组！
     * 执行用时 :0 ms, 在所有 java 提交中击败了100.00%的用户
     * 内存消耗 :36.1 MB, 在所有 java 提交中击败了85.44%的用户
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] help = new int[m + n];
        int index = 0;
        int l1 = 0, l2 = 0;
        while (l1 < m && l2 < n) {
            if (nums1[l1] < nums2[l2]){
                help[index++] = nums1[l1++];
            }
            else {
                help[index++] = nums2[l2++];
            }
        }
        while (l1 < m) {
            help[index++] = nums1[l1++];
        }
        while (l2 < n) {
            help[index++] = nums2[l2++];
        }
        for (int i = 0; i < m + n; i++) {
            nums1[i] = help[i];
        }
    }
}
