package week03

//2.2 https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
func maxProfit1s(prices []int) int {
	max := 0
	for i := 0; i < len(prices)-1; i++ {
		for j := i; j < len(prices); j++ {
			profit := prices[j] - prices[i]
			if profit > max {
				max = profit
			}
		}
	}
	return max
}

func maxProfit1(prices []int) int {
	max, min := 0, 126
	for i := 0; i < len(prices); i++ {
		if prices[i] < min {
			min = prices[i]
		}else if prices[i] - min > max {
			max = prices[i] - min
		}
	}
	return max
}

// https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/
func maxProfit2(prices []int) int {
	max := 0
	for i := 1; i < len(prices); i++ {
		if prices[i] > prices[i - 1]{
			max += prices[i]-prices[i - 1]
		}
	}

	return max
}