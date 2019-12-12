/**
 * @param {number[]} nums
 * @return {number}
 */
var majorityElement = function(nums) {
    const count = parseInt(nums.length/2);
    const hashTable = {};
    const result = [];
    nums.map(item => {
        if(result.indexOf(item) !== -1) return;
        const val = (hashTable[item] || 0) + 1;
        hashTable[item] = val;
        if(val > count) {
            result.push(item)
        }
    })
    return result;
};