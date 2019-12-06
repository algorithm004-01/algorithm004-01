//153. 寻找旋转排序数组中的最小值
//https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/


/**
 *1.二分法
 * @param nums
 * @returns {number|*}
 */
var findMin = function (nums) {
    var len = nums.length;
    if (len == 0) {
        return 0;
    }
    var left = 0;
    var right = len - 1;
    while (left < right) {
        // int mid = left + (right - left) / 2;
        var mid = (left + right) >>> 1;
        if (nums[mid] > nums[right]) {
            left = mid + 1;
        } else if (nums[mid] < nums[right]) {
            right = mid;
        } else {
            assert
            nums[mid] == nums[right];
            right--;
        }
    }
    return nums[left];
}



/**
 *2.分治法
 * @param nums
 * @returns {number|*}
 */
var findMin = function (nums) {
    var len = nums.length;
    if (len == 0) {
        throw new Error("数组为空，最小值不存在");
    }
    return helper(nums, 0, len - 1);
}

var helper = function (nums, left, right) {
    if (left + 1 >= right) {
        return Math.min(nums[left], nums[right]);
    }
    if (nums[left] < nums[right]) {
        return nums[left];
    }
    // int mid = left + (right - left) / 2;
    var mid = (left + right) >>> 1;
    return Math.min(helper(nums, left, mid - 1), helper(nums, mid, right));
}
