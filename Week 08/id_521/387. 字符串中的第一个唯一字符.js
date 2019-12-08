var firstUniqChar = function(s) {
  let map = {}
  for (let i of s) {
    map[i] = map[i] === undefined ? 1 : ++map[i]
  }
  debugger
  for (let i in s) {
    let c = s.charAt(i)
    if (map[c] === 1) {
      return i
    }
  }
}

firstUniqChar('leetcode')
