//1. Two Sum

/**
 * javascript
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