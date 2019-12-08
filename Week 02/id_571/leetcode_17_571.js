/**
 * @param {string} digits
 * @return {string[]}
 */
var letterCombinations = function(digits) {
  let res = [];
  if (digits === "") return res;
  let map = {
    "2": "abc",
    "3": "def",
    "4": "ghi",
    "5": "jkl",
    "6": "mno",
    "7": "pqrs",
    "8": "tuv",
    "9": "wxyz"
  };
  helper(res, digits, 0, "", map);
  return res;
};

var helper = function(arr, digits, index, str, map) {
  if (digits.length === index) {
    arr.push(str);
    return;
  }
  let letters = map[digits[index]];
  for (let s of letters) {
    helper(arr, digits, index + 1, str.concat(s), map);
  }
};
