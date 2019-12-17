import java.util.*;
/**
 * 2的幂
 */
class Solution {
    /**
     * 翻转对(使用归并排序算法)
     */
    public int reversePairs(int[] nums) {
        if (nums.length < 2) return 0;
        return reversePairsHelper(nums, 0, nums.length - 1);
    }

    private int reversePairsHelper(int[] nums, int left, int right) {
        if (left >= right) return 0;
        int mid = (left + right) >> 1;
        int count = reversePairsHelper(nums, left, mid) + reversePairsHelper(nums, mid + 1, right);
        for (int i = left, j = mid + 1; i <= mid; i++) {
            while (j <= right && nums[i] > (long) nums[j] << 1) j++;
            count += j - (mid + 1);
        }
        int[] tmp = new int[right - left + 1];
        int k = 0, l = left, r = mid + 1;
        while (l <= mid && r <= right)
            tmp[k++] = nums[l] < nums[r] ? nums[l++] : nums[r++];
        while (l <= mid) tmp[k++] = nums[l++];
        while (r <= right) tmp[k++] = nums[r++];
        System.arraycopy(tmp, 0, nums, left, tmp.length);
        return count;
    }

    /**
     * 翻转对(使用归并排序算法)
     * 改进版
     */
    public int reversePairs2(int[] nums) {
        if (nums.length < 2) return 0;
        return reversePairsHelper(nums, 0, nums.length - 1);
    }

    private int reversePairsHelper2(int[] nums, int left, int right) {
        if (left >= right) return 0;
        int mid = (left + right) >> 1;
        int count = reversePairsHelper2(nums, left, mid) + reversePairsHelper2(nums, mid + 1, right);
        int[] tmp = new int[right - left + 1];
        int k = 0, j = mid + 1, p = mid + 1;
        for (int i = left; i <= mid; i++) {
            while (j <= right && nums[i] > (long) nums[j] << 1) j++;
            while (p <= right && nums[i] > nums[p]) tmp[k++] = nums[p++];
            tmp[k++] = nums[i];
            count += j - mid - 1;
        }
        while (p <= right) tmp[k++] = nums[p++];
        System.arraycopy(tmp, 0, nums, left, tmp.length);
        return count;
    }
}