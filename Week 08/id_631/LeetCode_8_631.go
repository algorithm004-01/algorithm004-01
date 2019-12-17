
//trim left space
//trim left other
// 默认为0
//只算32位

const (
    int32Max = 1 << 31 - 1
    int32Min = -1 << 31
)

func myAtoi(str string) int {
    n := len(str)
    var i, j int
    neg := false

    //找出最高位
    for i = 0; i < n; i++ {
        if str[i] >= '0' && str[i] <= '9' {
            break
        } else if str[i] == '+' {
            i++
            break
        } else if str[i] == '-' {
            neg = true
            i++
            break
        } else if str[i] != ' ' {
            return 0
        }
    }

    //找出最后一位的下一位
    for j = i; j < n; j++ {
        if str[j] < '0' || str[j] > '9' {
            break
        }
    }

    ret := 0
    for k := i; k < j; k++ {
        cur := int(str[k] - '0')
        if !neg {
            ret = ret * 10 + cur
            if ret > int32Max {
                return int32Max
            }
        } else {
            ret = ret * 10 - cur
            if ret < int32Min {
                return int32Min
            }
        }
    }
    return ret
}