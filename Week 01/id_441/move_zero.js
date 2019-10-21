// 移动零
// https://leetcode-cn.com/problems/move-zeroes/
 const nums = [0,0,1,2,3,4,5,6,7,0,0,4,0,0,0,0,0]
var moveZeroes = function (nums) {
    let index = 0
    for(let i = 0; i<nums.length;i++){
        if(nums[i]!==0){
            if(i!==index){
                nums[index] = nums[i]
            nums[i] = 0

            }
            index++
        }
    }
}
moveZeroes(nums)
console.log(nums)