class Solution:
    def threeSum(self, nums: list):
        # 1：三层暴力破解
        res = []
        for i in range(len(nums)-2):
            for j in range(i+1, len(nums)-1):
                for k in range(j+1, len(nums)):
                    if nums[i] + nums[j] + nums[k] == 0:
                        res.append([nums[i], nums[j], nums[k]])
        return res

    def threeSum_2(self, nums: list):
        # 2：先排序 -> 排序后，转为two-sum 的问题
        # init res
        res = []
        exist = dict()
        # 做个排序
        nums.sort()
        # check
        if len(nums) < 3:
            return []

        # 开始照着 two-wum 来计算
        for i in range(len(nums)):
            frontIdx = i + 1
            backIdx = len(nums) - 1

            if frontIdx >= backIdx:
                break

            if nums[i] > 0:
                break

            if i > 0 and nums[i] == nums[i-1]:
                # if nums[frontIdx] != 0 and nums[backIdx] != 0:
                continue

            while frontIdx < backIdx:

                sum = nums[i] + nums[frontIdx] + nums[backIdx]
                if sum == 0:
                    res.append([nums[i], nums[frontIdx], nums[backIdx]])
                    while frontIdx < backIdx and nums[frontIdx] == nums[frontIdx+1]:
                        frontIdx += 1
                    while frontIdx < backIdx and nums[backIdx] == nums[backIdx-1]:
                        backIdx -= 1

                    frontIdx += 1
                    backIdx -= 1

                if sum > 0:
                    backIdx -= 1

                if sum < 0:
                    frontIdx += 1

        return res


if __name__ == '__main__':
    s = Solution()
    nums = [0,0,0]
    # res = s.threeSum(nums)
    res = s.threeSum_2(nums)
    print("Res: ", res)

