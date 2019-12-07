package medium;

/**
 * @author 潘磊明
 * @date 2019/11/5
 */
public class SearchInRotatedSortedArray {
//    public int search(int[] nums, int target) {
//        if (nums.length == 0) return -1;
//        if (nums.length == 1) return nums[0] == target ? 0 : -1;
//        int maxBroad = getBroad(nums);
//        if (maxBroad == -1) return _binarySearch(nums, 0, nums.length - 1, target);
//        if (target == nums[0]) return 0;
//        else if (target > nums[0]) return _binarySearch(nums, 0, maxBroad, target);
//        else return _binarySearch(nums, maxBroad + 1, nums.length - 1, target);
//    }
//
//    private int getBroad(int[] nums) {
//        int left = 0, right = nums.length - 1;
//        if (nums[left] < nums[right]) return -1;
//        while (right - left > 1) {
//            int mid = (left + right) / 2;
//            if (nums[mid] > nums[left]) left = mid;
//            else right = mid;
//        }
//        if (nums[left] > nums[right]) return left;
//        else return right;
//    }
//
//    private int _binarySearch(int[] nums, int left, int right, int target) {
//        if (nums[left] == target) return left;
//        if (nums[right] == target) return right;
//        while (left < right) {
//            if (nums[left] == target) return left;
//            if (nums[right] == target) return right;
//            int mid = (left + right) / 2;
//            if (nums[mid] > target) right = mid - 1;
//            else if (nums[mid] < target) left = mid + 1;
//            else return mid;
//        }
//        return -1;
//    }

    /**
     * 思路：例子数组[6,7,8,1,2,3,4,5]，target为7，可以把数组看成[6,7,8,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE]
     * 如果target为3，可以把数组看成[Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,1,2,3,4,5]
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            int num = target > nums[left] && nums[mid] > nums[left]
                    ? nums[mid] : target > nums[0]
                    ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            if (num < target) left = mid + 1;
            else if (num > target) right = mid;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        int target = 0;
        SearchInRotatedSortedArray s = new SearchInRotatedSortedArray();
        s.search(nums, target);
    }
}
