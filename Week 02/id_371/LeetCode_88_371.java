import java.util.Arrays;

/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-10-17 10:59
 **/

public class LeetCode_88_371 {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        merge(nums1, m, nums2, n);
        Arrays.stream(nums1).forEach(System.out::println);

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        //两个指针指向 nums1,num2的尾部,从大到小遍历两个额数组
        //n==0 --->说明nums2数组已经完全放入nums1中了
        //m==0 --->nums1先排好序了,只需要将 nums2中剩下的元素依次放入 nums1中即可
        for (int i = m + n - 1; i >= 0 && n > 0; i--) {
            if (m > 0 && nums1[m - 1] >= nums2[n - 1]) {
                nums1[i] = nums1[m - 1];
                m--;
            } else {
                nums1[i] = nums2[n - 1];
                n--;
            }
        }
    }


}
