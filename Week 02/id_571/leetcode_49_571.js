/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function(strs) {
  let map = {};
  for (let s of strs) {
    let key = s
      .split("")
      .sort((a, b) => a.localeCompare(b))
      .join("");
    if (!map.hasOwnProperty(key)) {
      map[key] = [];
    }
    map[key].push(s);
  }
  return Object.values(map);
};
