public class Solution {

    public int reversePairs(int[] nums) {
        if(nums.length <= 1) {
            return 0;
        }
        return mergeSort(nums, 0 , nums.length - 1);
    }

    public static int mergeSort(int[] array, int begin, int end) {
        int result = 0;
        if (begin == end) {
            return 0;
        }

        int mid = (begin + end) / 2;
        result += mergeSort(array, begin, mid);
        result += mergeSort(array, mid + 1, end);
        result +=  merge(array, begin, mid, end);
        return result;
    }

    public static int merge(int[] array, int begin, int mid, int end) {
        int result = 0;
        int firstBegin = begin;
        int secondBegin = mid + 1;
        int j = 0;
        int[] memo = new int[end - begin + 1];

        while (firstBegin <= mid && secondBegin <= end) {
            if(array[firstBegin] > 2L * array[secondBegin]) {
                result += mid - firstBegin + 1;
                secondBegin++;
            } else {
                firstBegin++;
            }
        }

        firstBegin = begin;
        secondBegin = mid + 1;
        while (firstBegin <= mid && secondBegin <= end) {
            memo[j++] = array[firstBegin] < array[secondBegin] ? array[firstBegin++] : array[secondBegin++];
        }

        while (firstBegin <= mid) {
            memo[j++] = array[firstBegin++];
        }

        while (secondBegin <= end) {
            memo[j++] = array[secondBegin++];
        }

        for (int i = 0; i < memo.length; i++) {
            array[begin++] = memo[i];
        }
        return result;
    }
}
