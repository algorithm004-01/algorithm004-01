
/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 * 解法一: 暴力解法; 时间复杂度为O(nlogn) + O(nlogn) = O(nlogn) 
 */
var isAnagram = function(s, t) {
    if(s.length !== t.length) {
        return false
    }
    var s_arr = [...s]
    var t_arr = [...t]
    s_arr.sort()
    t_arr.sort()
    s = JSON.stringify(s_arr)
    t = JSON.stringify(t_arr)
    return s === t
};


/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 * 解法二: 把字符传唤为0-25的数字， 对数字所在数组+-
 */
var isAnagram = function(s, t) {
    if(s.length != t.length) {
        return false
    }
    var arr = new Array(26).fill(0)
 
    for(let i = 0; i < s.length; i++) {
        arr[s.charCodeAt(i) - 97]++
        arr[t.charCodeAt(i) - 97]--
    }
 
    for(let item of arr) {
        if(item !== 0) {
            return false
        }
    }
    return true
 };