//合并数组并排序
public class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //int[] nums = new int[m+n];
        for (int i = 0; i < m; i++) {
            nums1[i] = nums1[i];
        }
        for (int i = 0; i < n; i++) {
            nums1[m++] = nums2[i];
        }
        for (int i = 0; i < nums1.length; i++) {
            for (int j = i+1; j < nums1.length; j++) {
                if (nums1[i] > nums1[j]) {
                    int temp = nums1[j];
                    nums1[j] = nums1[i];
                    nums1[i] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,0,0,0};
        int[] b = {2,5,6};
        int m = 3;
        int n = 3;
        Solution s = new Solution();
        s.merge(a,m,b, n);
    }

}
