var groupAnagrams = function (strs) {
    if (!strs.length) return [];
    let obj = {}
    let arr = []
    for (let k = 0; k < strs.length; k++) {
        const string = strs[k].split('').sort().join('')
        if (obj[string]) {
            obj[string].push(strs[k])
        } else {
            obj[string] = []
            obj[string].push(strs[k])
        }
    }
    for (let k in obj) {
        arr.push(obj[k])
    }
    return arr
}