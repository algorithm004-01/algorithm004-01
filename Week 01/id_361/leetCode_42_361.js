//42 Trapping Rain Water
// 此题困扰很久，思路都很接近，就是解不出，对细节的理解需要加强
/**
 * Method 1 direct
 * @param {number[]} height
 * @return {number}
 */
let trap = function(height) {
    let ans = 0;
    let size = height.length;
    for (let i = 1; i < size - 1; i++) {
        let max_left = 0, max_right = 0;
        for (let j = i; j >= 0; j--) { //Search the left part for max bar size
            max_left = Math.max(max_left, height[j]);
        }
        for (let j = i; j < size; j++) { //Search the right part for max bar size
            max_right = Math.max(max_right, height[j]);
        }
        ans += Math.min(max_left, max_right) - height[i];
    }
    return ans;
};
/**
 * Method 1 double pointer
 * @param {number[]} height
 * @return {number}
 */
let trap = function(height) {
    let left = 0, right = height.length - 1;
    let ans = 0;
    let left_max = 0, right_max = 0;
    while (left < right) {
        if (height[left] < height[right]) {
            height[left] >= left_max ? (left_max = height[left]) : ans += (left_max - height[left]);
            ++left;
        }
        else {
            height[right] >= right_max ? (right_max = height[right]) : ans += (right_max - height[right]);
            --right;
        }
    }
    return ans;
};
