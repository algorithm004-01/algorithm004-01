// 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
// [189. 旋转数组 - 力扣（LeetCode）](https://leetcode-cn.com/problems/rotate-array/)

/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 
 */
// 暴力解法
var rotate = function(nums, k) {
  var len = nums.length;
  var temp,previous;
  var realOffset = k % len;
  for(var i = 0;i<realOffset;i++) {
      var previous  =nums[len-1];
      for(var j=0;j<len;j++){
          var temp = nums[j];
          nums[j]= previous; 
          previous = temp
      }   
  }    
  
};

// 绝地反击，计算出一个数组的中间临界点，打断数组重新拼接即可
// k = 1 临界点是 reversePoint =7; k=2 reversePoint= 6  n - k%n

var rotate = function(nums,k) {
  var len = nums.length;
  var reversePoint =  len - k % len;
  reversePoint!== 0 && (nums = nums.slice(reversePoint).concat(nums.slice(0,reversePoint)))
}

// 环状替换

var rotate = function(nums,k){
 k = k% nums.length;
  var count = 0;
  for(var start=0;count<nums.length;start++) {
      var current = start;
      var prev = nums[start];
      do {
          var next = (current+k)%nums.length;
          var temp = nums[next];
          nums[next] = prev;
          prev  = temp;
          current = next;
          count++; 
      } while(start!=current)
  }
 
  
}