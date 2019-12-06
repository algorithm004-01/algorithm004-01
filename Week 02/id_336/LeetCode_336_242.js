// #### 解法一：暴力排序 sort O(NlogN)
/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
    if(s.length != t.length){
        return false;
    }
    var sSort = s.split('').sort();
    var tSort = t.split('').sort();
    return sSort.join('') == tSort.join('');
};
// #### 解法二：哈希表
/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
    if(s.length != t.length){
        return false;
    }
    var result = new Array(26);
    for(var i = 0;i<26;i++){
        result[i] = 0;
    }
    var aCode = 'a'.charCodeAt();
    for(var i = 0;i<s.length;i++){
        result[s[i].charCodeAt()-aCode]++;
        result[t[i].charCodeAt()-aCode]--;
    }
    for(var r = 0;r<result.length;r++){
        if(result[r]!=0){
            return false;
        }
    }
    return true;
};
// // + 优化版
// + 放在第二次遍历做判断，第一次遍历只维护一个增加表
// + 第二次只维护一个减小表，只要小于0就返回false
/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
    if(s.length != t.length){
        return false;
    }
    var result = new Array(26);
    for(var i = 0;i<26;i++){
        result[i] = 0;
    }
    var aCode = 'a'.charCodeAt();
    for(var i = 0;i<s.length;i++){
        result[s[i].charCodeAt()-aCode]++;
    }
    for(var r = 0;r<t.length;r++){
        var tmpCode = t[r].charCodeAt()-aCode;
        result[tmpCode]--;
        if(result[tmpCode] < 0){
           return false;
        }
    }
    return true;
};