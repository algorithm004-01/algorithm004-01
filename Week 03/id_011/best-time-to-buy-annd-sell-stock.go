package algorithm00401

func maxProfit(prices []int) int {
	minProfit := 1 << 31
	maxProfit := 0
	for i := 0; i < len(prices); i++ {
		if prices[i] < minProfit {
			minProfit = prices[i]
		} else if prices[i]-minProfit > maxProfit {
			maxProfit = prices[i] - minProfit
		}
	}
	return maxProfit
}
