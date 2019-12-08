/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
  if (s.length !== t.length) return false;
  let map = {};
  for (let c of s) {
    if (c in map) {
      let count = map[c] + 1;
      map[c] = count;
    } else {
      map[c] = 1;
    }
  }
  for (let c of t) {
    if (!(c in map)) {
      return false;
    } else {
      let count = map[c] - 1;
      map[c] = count;
    }
  }
  return Object.values(map).every(value => value === 0);
};
