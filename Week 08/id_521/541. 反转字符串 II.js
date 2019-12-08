var reverseStr = function(s, k) {
  var str = ''
  for (var i = 0; i < s.length; i++) {
    if (s.length >= i * 2 * k) {
      str += s
        .substr(2 * i * k, 2 * k)
        .substr(0, k)
        .split('')
        .reverse()
        .concat(
          s
            .substr(2 * i * k, 2 * k)
            .substr(k)
            .split('')
        )
        .join('')
    } else {
      sRemain = s.substr(i * 2 * k)
    }
  }
  if (sRemain.length < k) {
    return str
      .split('')
      .concat(sRemain.split('').reverse())
      .join('')
  } else if (sRemain.length >= k && sRemain.length < 2 * k) {
    return str
      .split('')
      .concat(
        sRemina
          .substr(0, k)
          .split('')
          .reverse()
          .concat(sRemain.substr(k).split(''))
      )
      .join('')
  } else {
    return str
  }
}
