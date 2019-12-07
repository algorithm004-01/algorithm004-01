package week03

// 2.1 https://leetcode-cn.com/problems/lemonade-change/description/
func lemonadeChange(bills []int) bool {

	var (
		five, ten int = 0, 0
	)
	for _, v := range bills {
		if v == 5 {
			five++
		}else if v == 10 {
			if five > 0 {
				five--
				ten++
			}else{
				return false
			}
		}else{
			if five > 0 && ten > 0 {
				five--
				ten--
			}else if five >= 3 {
				five = five - 3
			}else{
				return false
			}
		}
	}

	return true
}