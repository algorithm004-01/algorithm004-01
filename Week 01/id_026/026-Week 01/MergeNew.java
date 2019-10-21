//合并数组并排序
public class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pointer = m + n - 1;                                   //初始化指针位置为合并后的的数组末尾位置
        while (n > 0) {                                            //当nums2数组没遍历完，循环继续
            if (m > 0 && nums1[m - 1] > nums2[n - 1]) {            //如果在nums1数组没遍历完的情况下，nums1[m-1]大于nums2[n-1]（减1是实际下标）
                nums1[pointer--] = nums1[--m];                     //先将nums1[--m]（先自减m得到实际下标），赋值给nums[pointer]，然后指针向前移动
            } else {
                nums1[pointer--] = nums2[--n];                     //如果nums1数组遍历完或是nums1[m-1]小于nums2[n-1]，则赋值nums2[--n]给nums[pointer]
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
