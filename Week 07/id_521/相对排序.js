var relativeSortArray = function(arr1, arr2) {
  let maxValue = Math.max(...arr1)
  let bucket = new Array(maxValue + 1).fill(0)
  let result = []
  for (let i = 0; i < arr1.length; i++) {
    bucket[arr1[i]]++
  }
  for (let j = 0; j < arr2.length; j++) {
    while (bucket[arr2[j]] > 0) {
      result.push(arr2[j])
      bucket[arr2[j]]--
    }
  }
  for (let r = 0; r <= maxValue; r++) {
    while (bucket[r] > 0) {
      result.push(r)
      bucket[r]--
    }
  }
  return result
}
