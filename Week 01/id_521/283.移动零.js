
var 暴力 = function(nums) {
    
}


var 非最优 = function (nums) {
    //init: [0, 1, 0, 3, 12]

    let i = 0 ;

    for(let j = 0; j< nums.length; j++) {
        if(nums[j] !== 0) {
            nums[i] = nums[j] // 一样也交换，等于不交换
            i++
        }
    }
    //mid: [1, 3, 12, (3, 12)]  ()内已经可以替换为0

    for(let p = i; p < nums.length; p++) { 
        nums[p] = 0
    }

    //final: [1, 3, 12, 0, 0]


    //理解: i用来标记确定为非0的项目，她之后的项都可以变为0了
};



var 上面解优化 = function (nums) {
    //init: [0, 1, 0, 3, 12]

    let i = 0 ; // i其实不是指向0. i是用来确保该指针之前的数都不是0， 

    for(let j = 0; j< nums.length; j++) {
        if(nums[j] !== 0) {
            // nums[i] = nums[j] // 一样也交换，等于不交换
            if(j > i) { // 因为存在上面注释的问题， 所以加了个判断
                nums[i] = nums[j]
                nums[j] = 0
            }
            i++ /**1. nums[j] 赋值给nums[i] 后，原来i的位置已经确定是非0了，所以i需要+1,指向其后一个位置
                   2. 如果j和i指向同一个指针，但是nums[i|j] > 0, 这时候就不用替换了，该值肯定是非0, i直接+1，移到后一位
                **/
        }
    }
};






