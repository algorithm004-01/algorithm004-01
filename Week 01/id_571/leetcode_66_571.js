/**
 * @param {number[]} digits
 * @return {number[]}
 */
var plusOne = function(digits) {
  let flag = true;
  let index = digits.length - 1;
  while (flag && index >= 0) {
    digits[index] += 1;
    if (digits[index] === 10) {
      digits[index] = 0;
    } else {
      flag = false;
    }
    index--;
  }
  if (flag && index < 0) {
    digits.unshift(1);
  }
  return digits;
};

/**
 * @param {number[]} digits
 * @return {number[]}
 */
var plusOne = function(digits) {
  for (let i = digits.length - 1; i >= 0; i--) {
    if (digits[i] !== 9) {
      digits[i]++;
      return digits;
    }
    digits[i] = 0;
  }
  digits.unshift(1);
  return digits;
};