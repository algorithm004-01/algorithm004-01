package simple;

/**
 * @author 潘磊明
 * @date 2019/10/22
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n < 1) return;
        if(m < 1) {
            while (n-- > 0) {
                nums1[n] = nums2[n];
            }
        }
        int i = m - 1, j = n - 1;
        while (i > -1 || j > -1) {
            if (i < 0) {
                while (j > -1) {
                    nums1[j] = nums2[j];
                    j--;
                }
            } else if(j < 0) {
                return;
            }else {
                if (nums1[i] > nums2[j]) {
                    nums1[i + j + 1] = nums1[i];
                    i--;
                }else {
                    nums1[i + j + 1] = nums2[j];
                    j--;
                }
            }
        }
    }
}
