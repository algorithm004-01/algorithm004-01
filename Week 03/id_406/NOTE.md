# NOTE

  
贪心算法
贪心算法是一种在每一步选择中都采取在当前状态下最好或最优(即最有利)的选择，从而希望导致结果是全局最好或最优的算法
贪心算法与动态规划的不同在于它对每个子问题的解决方案都做出选择，不能回退。动态规划则会保存以前的运算结果，并根据以前的结果对当前进行选择，有回退功能

二分查找模板
left, right = 0, len(array) - 1
while left <= right:
	mid = (left + right) / 2
	if array[mid] == target:
		break or return result
	elif array[mid] < target:
		left = mid + 1
	else:
		right = mid - 1
