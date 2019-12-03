package id_736

//1. 先二分遍历找到分隔点index，特征是 < 前一个元素, >后一个元素;
//2. 把数组分成二个部分，[0,index-1], [index,length-1];
//3. 分别使用二分查找，找到给定的值。
//时间复杂度为log(n). 不确定有什么更好的办法

func search(nums []int, target int) int {
	if len(nums) == 0 {
		return -1
	}

	n := len(nums) - 1
	divisionIndex := findDivision(nums)
	if divisionIndex == 0 || divisionIndex == -1 {
		//非旋转排序数组
		return findTarget(nums, 0, n, target)
	}

	res := findTarget(nums, 0, divisionIndex-1, target)
	if res != -1 {
		return res
	}
	return findTarget(nums, divisionIndex, n, target)
}

//找到分割点
func findDivision(nums []int) int {
	low, high := 0, len(nums)-1
	for low < high {
		mid := low + (high-low)>>1

		if nums[high] < nums[mid] {
			low = mid + 1
		} else {
			high = mid
		}
	}
	return low
}

func findTarget(nums []int, low, high, target int) int {
	for low <= high {
		mid := low + (high-low)>>1
		if nums[mid] > target {
			high = mid - 1
		} else if nums[mid] < target {
			low = mid + 1
		} else {
			return mid
		}
	}
	return -1
}
