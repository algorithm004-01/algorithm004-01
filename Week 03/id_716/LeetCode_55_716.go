package id_716

// https://leetcode-cn.com/problems/jump-game/
// 跳跃游戏

// 贪心算法
// 要点：从最后1个位置往前找，如果前面的位置能够到达指定的后面的位置，说明是可达的，然后就更新要判断的位置，一直到结束
// 如果最后没有办法回到起始位置，说明不能到达最后一个位置
func canJump(nums []int) bool {
	pos := len(nums) - 1
	for i := pos; i >= 0; i-- {
		if i + nums[i] >= pos { pos = i }
	}
    return pos == 0
}