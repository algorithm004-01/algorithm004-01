class Solution:
    def twoSum(self, nums: list, target: int) -> list:
        # check exist
        exist = dict()
        res = []
        # for one loops
        for index in range(len(nums)):
            # store current value
            value = nums[index]
            # check two numbers whether exist
            if (target - value) in exist:
                if index == exist.get(target-value):
                    continue
                return [exist.get(target-value), index]
            exist.update({
                value: index
            })
        # not exist
        return []

if __name__ == '__main__':
    '''
    For test.
    仅返回头一个遇到的结果。
    '''
    s = Solution()
    nums = [0, 1, 2, 3, 5, 8]
    target = 6
    print("res: ", s.twoSum(nums, target))
