/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function(nums) {
    let i=0,j=0;
    for(i=0; i<nums.length-1; i++){
        if(nums[i] != nums[i+1]){
            j++;
            nums[j] = nums[i+1];
        }
    }
    nums = nums.splice(j+1);
    return j+1;
};