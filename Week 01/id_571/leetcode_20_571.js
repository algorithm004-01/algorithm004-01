/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function(str) {
  let stack = [];
  let map = {
    "(": ")",
    "{": "}",
    "[": "]"
  };
  for (let s of str) {
    let top = stack[stack.length - 1];
    if (s === map[top]) {
      stack.pop();
    } else {
      stack.push(s);
    }
  }
  return stack.length === 0;
};
