var isAnagram = function(s, t) {
  let arrS = Array.prototype.slice
    .call(s)
    .sort()
    .toString()
  let arrT = Array.prototype.slice
    .call(t)
    .sort()
    .toString()

  if (arrS === arrT) {
    return true
  }
  return false
}
