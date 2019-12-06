/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-11-28 04:59
 **/

public class Leetcode_493_371 {


    public static void main(String[] args) {
//        int[] nums = {1, 3, 2, 3, 1};
//        int[] nums = {2,4,3,5,1};
        int[] nums = {2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647};
        int count = reversePairs1(nums);
        System.out.println("count = " + count);
    }

    /**
     * 仿解1:归并排序
     *
     * @author Shaobo.Qian
     * @date 2019/11/28
     */
    public static int reversePairs1(int[] nums) {

        return mergeSort(nums, 0, nums.length-1);
    }

    private static int mergeSort(int[] nums, int begin, int end) {
        //1.terminator
        if ( begin >= end) return 0;
        int mid = begin + ((end - begin) >> 1);
        //3.drill down(分治)
        int lCount = mergeSort(nums, begin, mid);
        int rCount = mergeSort(nums, mid + 1, end);
        int nCount = 0;
        //2.1找出翻转对,每次取左半边的数组依次和右半边数组中的一个元素比较(因为归并排序后,此时左右两边数组都已经排好序)
        for (int left = begin, right = mid + 1; right <= end; right++) {
            while (left <= mid && nums[left] <= (long) 2 * nums[right]) left++; //左半边数组剩下的元素相对 当前的nums[right]来说,都是翻转对
            if (left > mid) break;
            nCount += mid - left + 1;
        }
        //2.2将左右两边数组归并排序
        merge(nums, begin, end, mid);
        return lCount + rCount + nCount;
    }

    private static void merge(int[] nums, int begin, int end, int mid) {
        int[] temp = new int[end - begin + 1];//排序后数组,(end - begin + 1)数组大小
        int i = begin, j = mid + 1, k = 0;
        //1.左右两边数组元素都没有取完的情况
        while (i <= mid && j <= end) {
            temp[k++] = nums[i] <= nums[j] ? nums[i++] : nums[j++];
        }
        //2.剩下左边数组还有元素没有取完
        while (i<=mid) temp[k++] = nums[i++];
        //3.剩下左边数组还有元素没有取完
        while (j<=end) temp[k++] = nums[j++];
        //4.用排序后的数组替换原数组
        for (int p = 0; p < temp.length; p++) {
            nums[begin + p] = temp[p];
        }
    }

    /**
     * 原解1.
     *
     * @author Shaobo.Qian
     * @date 2019/11/28
     */
    public static int reversePairs(int[] nums) {
        //1.排序
//        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > (long) 2 * nums[j]) count++;
            }
        }
        return count;
    }
}
