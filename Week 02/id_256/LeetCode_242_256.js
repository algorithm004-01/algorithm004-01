/*
 * @lc app=leetcode.cn id=242 lang=javascript
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
  // 暴力法
  // if(s.length != t.length) return false;
  // let s_arr = s.split('');
  // let t_arr = t.split('');
  // s_arr = s_arr.sort();
  // t_arr = t_arr.sort();
  // return s_arr.join('') == t_arr.join('');

  //map法
  let letterMap = {};
  if (s.length != t.length) return false;
  for (let i = 0; i < s.length; i++) {
    if (letterMap[s[i]] == undefined) {
      letterMap[s[i]] = 1;
    } else {
      letterMap[s[i]]++;
    }
  }
  for (let j = 0; j < t.length; j++) {
    if (letterMap[t[j]] == undefined) {
      return false;
    } else {
      letterMap[t[j]]--;
    }
  }
  for (let key in letterMap) {
    if (letterMap[key] != 0) {
      return false;
    }
  }
  return true;
};
// @lc code=end
