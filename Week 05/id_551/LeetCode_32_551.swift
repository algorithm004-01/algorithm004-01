func maxVaildLength(arr: [String]) {
    var current = 0
    var targetArr = [String]()
    for string in arr {
        var value = 0
        if string == ")" {
            value = -1
        }else {
            value = 1
        }
        if current + value >= 0 {
            targetArr.append(string)
            current += value
        }
    }
    print(targetArr.count - current)
}
