/**
 * @param {number[]} height
 * @return {number}
 */
var maxArea = function(height) {
  let max = 0;
  for (let i = 0, j = height.length - 1; i < j; ) {
    let minHeight = height[i] < height[j] ? height[i++] : height[j--];
    let area = (j - i + 1) * minHeight;
    max = Math.max(max, area);
  }
  return max;
};

var maxArea = function(height) {
  let max = 0;
  for (let i = 0; i < height.length - 1; i++) {
    for (let j = i + 1; j < height.length - 1; j++) {
      let area = (j - i) * Math.min(height[i], height[j]);
      max = Math.max(max, area);
    }
  }
  return max;
};

maxArea([2, 3, 4, 5, 18, 17, 6]);
