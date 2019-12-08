/**
 * @param {number[]} arr1
 * @param {number[]} arr2
 * @return {number[]}
 */
// 计数排序

var relativeSortArray = function(arr1, arr2) {
  let maxValue = Math.max(...arr1);
  // 生成最大的数+1的数组，并填充为0
  let bucket = new Array(maxValue+1).fill(0);
  let result = [];

  // 对arr1内的数字进行统计
  for(let i = 0;i < arr1.length;i++){
      bucket[arr1[i]]++;   
  }
  // 根据arr2内的数字依次拿出放到result内
  for(let j = 0;j < arr2.length;j++){
    // 直到bucket内对应数字个数为0时才停止
      while(bucket[arr2[j]] > 0){
          result.push(arr2[j]);
          bucket[arr2[j]]--;
      }
  }
  // 按升序拿出剩余的数字
  for(let r = 0;r <= maxValue;r++){
      while(bucket[r] > 0){
          result.push(r);
          bucket[r]--;
      }
  }
  return result;
}