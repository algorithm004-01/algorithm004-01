class Solution {
    //按照顺序合并
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        int i=m-1;
        int j=n-1;
        int k = m+n-1;
        while (i >= 0 && j >= 0) {
            int v1 = nums1[i];
            int v2 = nums2[j];
            if (v1 >= v2) {
                nums1[k] = v1;
                i--;
            }else {
                nums1[k] = v2;
                j--;
            }
            k--;
        }
        while(j>=0) {
            nums1[k] = nums2[j];
            k--;
            j--;
        }
    }

    //暴力
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        for (int i = 0; i < n ; i++) {
            nums1[m+i] = nums2[i];
        }
        Arrays.sort(nums1);
    }
}