package id_716

// 旋转数组: https://leetcode-cn.com/problems/rotate-array/

// 1. 笨方法，一个一个移动, 每次只移动一个，时间复杂度 O(n*k)
func rotate1(nums []int, k int) {
	length := len(nums)
	k = k % length
	if k == 0 { return }

	for i := 0; i < k; i++ {
		tmp := nums[length - 1]
		for j := length - 2; j >= 0; j-- {
			nums[j + 1] = nums[j]
		}
		nums[0] = tmp
	}
} 

// 2. 使用新数组 Copy，当k确定后，进行旋转后的位置是确定的 (i + k) % length
// 时间复杂度 O(n) 空间复杂度 O(n)
func rotate2(nums []int, k int) {
	// 申请一个新切片
	tmpNums := make([]int, len(nums))
	
	// 将旋转后的数组放在临时切片中
	for i := range nums {
		pos := (i + k) % len(nums)
		tmpNums[pos] = nums[i]
	}

	// copy to nums
	copy(nums, tmpNums)
}

// 3. 反转
// 反转整个字符串，然后反转前k个，再反转后n-k个
func rotate3(nums []int, k int) {
	length := len(nums)
	k = k % length

	reverse(nums, 0, length - 1)
	reverse(nums, 0, k - 1)
	reverse(nums, k, length - 1)
}

// 反转的思路是根据中间为轴，对称交换
func reverse(nums []int, start, end int) {
	for i, j := start, end; i < j; i, j = i + 1, j - 1 {
		nums[i], nums[j] = nums[j], nums[i]
	}
}

// 4. 交换法，这个思路是最开始想起来的，但是在落地代码时出现了问题，有一部分逻辑不知道代码如何写
// 思路是：旋转后每个位置是确定的，所以走一遍，把所有元素放在他应有的位置上，代码实现稍微有些复杂
// 时间复杂度 O(n), 空间复杂度 O(1)
func rotate4(nums []int, k int) {
	length := len(nums)
	if k = k % length; k == 0 {
		return
	}

	// 移动次数
	moveCnt := 0
	startPos := 0
	currentValTmp := -1
	nextValTmp := -1

	for moveCnt < length {
		currentPos := startPos
		currentValTmp = nums[startPos]

		// 当形成环时，进入到下一轮替换
		nextPos := (currentPos + k) % length
		for nextPos != startPos {
			// 计算当前元素移动到的位置
			nextPos = (currentPos + k) % length

			// 移动过去
			nextValTmp = nums[nextPos]
			nums[nextPos] = currentValTmp

			// 切换指针，准备进入下一轮移动
			currentPos = nextPos
			currentValTmp = nextValTmp

			moveCnt++
		}

		startPos++
	}
}

// 5. golang 中比较 tricky 的写法
func rotate5(nums []int, k int) {
	length := len(nums)
	k %= length
	// if k == 0 { return }
	temp := append(nums[length - k:], nums[:length - k]...)
	copy(nums, temp)
}
