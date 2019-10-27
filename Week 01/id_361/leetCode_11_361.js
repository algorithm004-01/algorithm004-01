//


/**
 * 暴力法
 * @param {number[]} arr
 * @return {number}
 */
let maxArea = function (arr) {
    let max = 0
    for (let i = 0; i < arr.length -1 ; ++i) {
        for (let j = i + 1; j < arr.length; ++j) {
            let area = (j - i) * Math.min(arr[i], arr[j])
            max = Math.max(max, area)
        }
    }
    return max;
}

/**
 * 双指针法，哪边低移动哪边
 * @param {number[]} arr
 * @return {number}
 */
let maxArea = function (arr) {
    let maxarea = 0, l = 0, r = arr.length - 1;
    while (l < r) {
        maxarea = Math.max(maxarea, Math.min(arr[l], arr[r]) * (r - l));
        if (arr[l] < arr[r])
            l++;
        else
            r--;
    }
    return maxarea;
};
