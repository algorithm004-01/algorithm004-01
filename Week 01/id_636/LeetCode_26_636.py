class Solution:
    def removeDuplicates(self, nums: list) -> (int, list):
        # check length
        if len(nums) <= 1:
            return len(nums), nums

        # init len
        arrayLen = 0
        # cur, next = 0, 0
        cur = 0
        # for loop
        while True:
            # get value
            value = nums[cur]

            if cur + 1 < len(nums) and value == nums[cur + 1]:
                del nums[cur + 1]
                continue

            cur += 1
            if cur == len(nums):
                break

        return len(nums), nums

if __name__ == '__main__':
    s = Solution()
    nums = [0,0,1,1,1,2,2,3,3,4,4,5,6,7,8,8,9,9,9,9,9,9,9,9,9]
    arrayLen, nums = s.removeDuplicates(nums)
    print("After: ", nums)
    print("Len: ", arrayLen)