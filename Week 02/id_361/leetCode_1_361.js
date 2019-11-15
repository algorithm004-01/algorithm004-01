//1. Two Sum

/**
 * javascript
 * 1.暴力法
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    var arr=[]
    for(let i=0;i<nums.length;i++){
        for(let j=i+1;j<nums.length;j++){
            if(target - nums[i]=== nums[j]){
                arr.push(i)
                arr.push(j)
            }
        }
    }
    return arr
};

/**
 * javascript
 * 2.两遍哈希表
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    let  map = new Map()
    for (let i = 0; i < nums.length; i++) {
        map.set(nums[i], i);
    }
    for (let i = 0; i < nums.length; i++) {
        let complement = target - nums[i];
        if (map.has(complement) && map.get(complement) != i) {
            return [ i, map.get(complement) ];
        }
    }
    throw new Error("No two sum solution");
};

/**
 * javascript
 * 2.一遍哈希表
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    let map = new Map();
    for (let i = 0; i < nums.length; i++) {
        let complement = target - nums[i];
        if (map.has(complement)) {
            return [map.get(complement), i];
        }
        map.set(nums[i], i);
    }
    throw new Error("No two sum solution");
};
