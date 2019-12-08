package algorithm00401

func twoSum(numbers []int, target int) []int {
	memo := make(map[int]int)
	for i := 0; i < len(numbers); i++ {
		sub := target - numbers[i]
		if j, ok := memo[sub]; ok {
			return []int{j, i}
		} else {
			memo[numbers[i]] = i
		}
	}
	return nil
}
