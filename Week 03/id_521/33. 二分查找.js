/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 * [4,5,6,7,0,1,2,3 4]
 */
var search = function(nums, target) {
   let right = nums.length;
    if(right === 0 ){
        return -1
    }
   return recursion(0, right-1, nums, target)

  function recursion(left, right, nums, target) {
    if(left > right ) return -1;
    let mid = (left + right) / 2 | 0;
    if (nums[mid] === target) {
      return mid;
    }

    if (nums[right] > nums[mid]) { //有序的
      if (nums[right] >= target && nums[mid] < target) { 
        return recursion(mid+1, right, nums, target);
      }
      return recursion(left, mid - 1, nums, target)
    } else {
        if (nums[left] <= target && nums[mid] > target) { 
            return recursion(left, mid - 1, nums, target);
        }
        return recursion(mid+1, right , nums, target)
    }

  }
};
