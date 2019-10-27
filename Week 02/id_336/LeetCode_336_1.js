// #### 解法一：暴力枚举
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    var result = [];
    var len = nums.length;
    for(var i=0;i<len;i++){
        // j从 i+1 开始 确保不重复利用同一个元素
        for(var j =i+1;j<len;j++){
            if(nums[i] + nums[j] == target){
                result.push(i);
                result.push(j);
                return result;
            }
        }
    }
};
// #### 解法二：两次哈希表 空间换时间
var twoSum = function(nums, target) {
    var result = new Map();
    var len = nums.length;
    var out = [];
    for(var r=0;r<len;r++){
        result.set(nums[r],r);
    }
    for(var i=0;i<len;i++){
        var tmpDiff=target-nums[i];
        var need = result.get(tmpDiff);
        if(need!=undefined && need!=i){
            out.push(i);
            out.push(need);
            return out;
        }
    }
};