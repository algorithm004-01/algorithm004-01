
/**
 * [11. 盛最多水的容器 - 力扣（LeetCode）](https://leetcode-cn.com/problems/container-with-most-water/)
 * @param {number[]} height
 * @return {number}
 */
/**
 * 粗暴解法，直接遍历 n^2
 */

var maxArea = function(height) {
  let maxArea=0;
  if(!(height.length>0)) return maxArea
  for(let i=0;i<height.length;i++){
      for (let j=i+1;j<height.length;j++) {
          maxArea = Math.max(maxArea,Math.min(height[i],height[j])*(j-i))
      }
  }
  return maxArea
};

/**双指针法
* 逻辑思路在于

1 i从最左端开始，j从最右端开始，此时长度最长(j-i)，高度等于 Math.min(height[i],height[j]);
2 移动短边，可能比当前长 也可能比当前短，那面积可能大于当前
3 移动长边，可能比短边长：高度还是短边，长度变短，所以面积小于当前 可能比短边短，长宽都短，所以 还是小于当前

*/

var maxArea = function(height) {
  let maxArea=0;
  if(!(height.length>0)) return maxArea;
  let i = 0,j = height.length-1;
  while(i < j) {
       maxArea = height[i] < height[j] ? Math.max(maxArea,(j-i)*height[i++]):Math.max(maxArea,(j-i)*height[j--]);
  }
  return maxArea
};