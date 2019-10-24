import java.util.Arrays;

public class MergeSortedArray {
    //往后存大的数
    /*public void merge(int[] nums1, int n, int[] nums2, int m) {
        int i=m-1,j=n-1;
        int k = m+n-1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
           while (i >= 0) {
            nums1[k--] = nums1[i--];
        }
          while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }*/
        // 先插入，在排序
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }
    //向前排序输入，与合并链表类似

}
