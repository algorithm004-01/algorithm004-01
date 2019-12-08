//因为 20 可以用10 和 5 换， 10 可以 用5 换 
// 贪心策略需要尽可能地多留 5元在手上，防止10元的顾客无法找零。
// 85.25%, 100%
func lemonadeChange(bills []int) bool {
    five := 0
    ten := 0
    for _, bill := range bills {
        if bill == 5 {
            five++
        } else if bill == 10 {
            if five >= 1 {
                five--
                ten++
            } else {
                return false
            }
        } else if bill == 20 {
            if ten >= 1 && five >= 1 {
                five--
                ten--
            } else if five >= 3 {
                five = five - 3
            } else {
                return false
            }
        } else {
            return false
        }
    }   
    return true
}