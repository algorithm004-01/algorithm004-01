/*
 * @lc app=leetcode.cn id=49 lang=javascript
 *
 * [49] 字母异位词分组
 */

// @lc code=start
/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function(strs) {
  // 排序
  //   if (strs.length <= 0) return [];
  //   let str_map = {};
  //   for (let i = 0; i < strs.length; i++) {
  //     let str = strs[i];
  //     str = str
  //       .split("")
  //       .sort()
  //       .join("");
  //     if (str_map[str] == undefined) {
  //       str_map[str] = [strs[i]];
  //     } else {
  //       str_map[str].push(strs[i]);
  //     }
  //   }
  //   let arr = [];
  //   for(let key in str_map) {
  //       arr.push(str_map[key]);
  //   }
  //   return arr;
  let str_map = {};
  let result = [];
  for (let i = 0; i < strs.length; i++) {
    let hashMap = [];
    for (let j = 0; j < 26; j++) {
      hashMap[j] = 0;
    }
    let str = strs[i];
    let aCode = "a".charCodeAt();
    for (let k = 0; k < str.length; k++) {
      hashMap[str[k].charCodeAt() - aCode]++;
    }
    let strKey = hashMap.join("");
    if (str_map[strKey] == undefined) {
      str_map[strKey] = [];
    }
    str_map[strKey].push(str);
  }
  for (let key in str_map) {
    result.push(str_map[key]);
  }
  return result;
};
// @lc code=end
