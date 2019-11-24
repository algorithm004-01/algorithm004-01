public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int ia = m-1;
        int ib = n-1;

        for (int i = m+n-1;i>=0;i--) {
            if (ia >=0 && ib >= 0) {
                if (nums1[ia] > nums2[ib]) {
                    nums1[i] =  nums1[ia];
                    ia--;
                } else {
                    nums1[i] =  nums2[ib];
                    ib--;
                }
            } else if (ia >=0 && ib < 0) {
                break;
            } else if (ia <0 && ib >= 0) {
                nums1[i] =  nums2[ib];
                ib--;
            }
        }
    }
}
