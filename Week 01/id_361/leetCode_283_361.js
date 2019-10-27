/**
 * method 1.move zero to the array end
 * @param {number[]} nums
 * @return {void}
 */
let moveZeroes = function(nums) {
    for(let i=0;i<nums.length;i++){
        if(nums[i]===0){
            let temp=nums[i];
            nums.splice(i, 1);
            nums.push(temp);

        }
    }
};


/**
 * method 2. recorder next not zero and swap
 * @param {number[]} nums
 * @return {void}
 */
let moveZeroes = function(nums) {
    let j=0; //recorder next not zero element position
    for(let i=0;i<nums.length;i++){
        if(nums[i]!=0){
            nums[j]=nums[i]; //swap
            if(i!=j){
                nums[i]=0
            }
            j++
        }
    }

};


/**
 * method 3. snowball
 * reference：https://leetcode.com/problems/move-zeroes/discuss/172432/THE-EASIEST-but-UNUSUAL-snowball-JAVA-solution-BEATS-100-(O(n))-%2B-clear-explanation
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
let moveZeroes = function(nums) {
    let snowBallSize=0
    for(let i=0;i<nums.length;i++){
        if(nums[i]===0){
            snowBallSize++
        }
        else if(snowBallSize>0){
            let t = nums[i];
            nums[i]=0;
            nums[i-snowBallSize]=t;
        }
    }
};


