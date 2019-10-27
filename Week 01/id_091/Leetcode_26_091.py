from typing import List


class Solution(object):
    # 可用一遍遍历，即根据当前遍历得到的元素index，
    # 查找target-index是否在剩余数组里出现
    # 如果找得到，则返回其下标值；反之则说明没有该答案
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        answer = []
        for left_index in range(len(nums)):
            right = target - nums[left_index]
            if right in nums[left_index + 1:]:
                nums_right = nums[left_index + 1:]
                right_index = nums_right.index(right) + left_index + 1
                answer.extend([left_index, right_index])
                break
        return answer

    def tow_sum_with_dict(self, nums: List[int], target: int) -> List[int]:
        _dict = {}
        for i, m in enumerate(nums):
            if _dict.get(target - m) is not None:
                return [i, _dict.get(target - m)]
            _dict[m] = i


if __name__ == "__main__":
    nums = [-1, -2, -3, -4, -5]
    target = -3
    answer = Solution().tow_sum_with_dict(nums, target)
    print(answer)
