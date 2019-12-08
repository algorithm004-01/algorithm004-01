'''

jump-game-ii_45

给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

你的目标是使用最少的跳跃次数到达数组的最后一个位置。

示例:

输入: [2,3,1,1,4]

输出: 2

说明:
假设你总是可以到达数组的最后一个位置。
'''

def jump(nums):
    last_max_reach, current_max_reach = 0, 0
    njump, i = 0, 0
    while current_max_reach < len(nums)-1:
        while i <= last_max_reach:
            current_max_reach = max(i+nums[i], current_max_reach)
            i += 1
        if last_max_reach == current_max_reach:
            return -1
        last_max_reach = current_max_reach
        njump += 1
    return njump


#优化
def jump_2(nums):
    if len(nums) == 1:
        return 0
    cur = 0
    max_jump = 0
    k = nums[0]
    tm = 1
    while cur <= max_jump:
        max_jump = max(cur+nums[cur], max_jump)
        if cur == k:
            k = max_jump
            tm += 1
        cur +=1
        if max_jump >= len(nums)-1:
            if k >= len(nums)-1:
                return tm
            else:
                return tm+1
