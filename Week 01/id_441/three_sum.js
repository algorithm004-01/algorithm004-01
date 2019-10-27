// https://leetcode-cn.com/problems/two-sum/
// 两数之和
// 1暴力求解
var twoSum = function (nums, target) {
    const targetArr = []
    for (let i = 0; i < nums.length - 1; i++) {
        for (let j = i + 1; j < nums.length; j++) {
            if (target === nums[i] + nums[j]) {
                targetArr.push(i)
                targetArr.push(j)
            }
        }
    }
    return targetArr
};
// 2 哈希
var twoSum = function (nums, target) {
    const resObj = {}
    for (let i = 0; i < nums.length; i++) {
        resObj[target - nums[i]] = i
    }
    for (let k = 0; k < nums.length; k++) {
        if (resObj[nums[k]] && resObj[nums[k]] !== k) {
            return [k, resObj[nums[k]]]
        }
    }
}
// https://leetcode-cn.com/problems/3sum/
// 三数之和
// 暴力求解法
var threeSum = function (nums) {
    const targetArr = []
    for (let i = 0; i < nums.length - 2; i++) {
        for (let j = i + 1; j < nums.length - 1; j++) {
            for (let k = j + 1; k < nums.length; k++) {
                if (nums[i] + nums[j] + nums[k] === 0) {
                    targetArr.push([nums[i], nums[j], nums[k]])
                }
            }
        }
    }
    return targetArr
};
var threeSum = function (nums) {
    // nums = sort(nums);
    nums.sort((a, b) => a - b)
    for (let i = 1; i < nums.length - 1; i++) { // C位人选
        let first = 0
        let last = nums.length - 1
        console.log(last, 'last')
        do {
            let result = nums[i] + nums[first] + nums[last]
            if (result === 0) { // 如果可以组队
                res.push([nums[i], nums[first], nums[last]])
            }
            if (result <= 0 && first < i) { // 实力太弱，把菜鸟那边右移一位
                while (nums[first] === nums[++first]); // 如果相等就跳过
            } else if (result > 0 && last > i) { // 实力太强，把大神那边右移一位
                while (nums[last] === nums[--last]);
            } else {
                break // 某一边已经没有人选了
            }
        } while (1) {}
    }
    return res
}
// 这里是冒泡实现的，复杂度为O(n^2);应用快排，复杂度为logN
function sort(nums) {
    const length = nums.length - 1
    while (length) {
        for (let i = 0; i < nums.length; i++) {
            if (nums[i] > nums[i + 1]) {
                const num = nums[i + 1]
                nums[i + 1] = nums[i]
                nums[i] = num
            }
        }
        length--
    }
}