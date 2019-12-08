// leetcode - https://leetcode-cn.com/problems/two-sum/

func twoSum(nums []int, target int) []int {
    hash := make(map[int]int)
    for i:= 0; i < len(nums); i ++ {
        expect := target - nums[i]
        if j, ok := hash[expect]; ok {
            return []int{i, j}
        } else {
            hash[nums[i]] = i
        }
    }
    return nil
}