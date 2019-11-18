import java.util.Arrays;

/**
 * BinarySearch
 */
public class BinarySearch {

    public int binarySearch(int[] nums,int target) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                return target;
            }else if (nums[mid] < target) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
    }
    

}