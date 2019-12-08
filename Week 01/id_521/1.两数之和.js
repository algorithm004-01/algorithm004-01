// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 * 暴力破解: 时间复杂度： O(n**2), 空间复杂度 O(1) 
 */
var twoSum = function(nums, target) {
    for(let i = 0; i < nums.length; i++) {
        for(let j = i + 1; j < nums.length; j++) {
            if((nums[i] + nums[j]) === target) {
                return [i, j]
            }
        }
    }
};


/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 * 暴力破解: O(n**2)
 * 法拉利: 使用hash表
 */
var twoSum = function(nums, target) {
    const map = new Map();
    for(let i = 0; i < nums.length; i++) {
        let currentIndex = map.get(target - nums[i]) // 查找nums[i]的另一半是否已经在map里面了， 如果没有把nums[i]放入，等待有人来找他
        if(currentIndex !== undefined) {
            return [currentIndex, i]
        }
        map.set(nums[i], i)
    }
  };

