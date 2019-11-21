# 整个任务列表执行的长度取决于执行次数最多的那个任务，次数最多的任务优先安排执行，因此我们将任务按出现次数排序。
# 假设次数最多的任务A的次数为l，冷却时间为n。那么执行整个任务列表至少需要的时间为 (l - 1) * (n + 1) + 1。
# 其中l单位时间用来执行A，其余的时间可以用来执行其他任务或者等待。
# 接下来继续按出现次数顺序处理下一个任务：
# 1. 如果出现次数和最大的一样，则执行时间+1，因为需要在非空闲时间处理
# 2. 如果出现次数小于最大值，则将空闲时间减去任务数量
# 3. 如果在空闲时间使用完之前，处理完了所有任务，那么空闲时间就是等待，返回结果
# 4. 如果空闲时间用完，还有未完成的任务，说明该组任务可以在没有等待的情况下完成任务，那么结果即为任务序列的长度。
class Solution:
    # def leastInterval(self, tasks: List[str], n: int) -> int:
    #     length = len(tasks)
    #     if length < 1:
    #         return length
    #     # 计算每个任务出现的次数
    
    #     map.sort()
    #     maxTaskCount = map[25]
    #     leastIntervalTime = (maxTaskCount - 1) * (n + 1) + 1
    #     i = 24
    #     while map[i] > 0 and i > 0:
    #         if map[i] == maxTaskCount:
    #             leastIntervalTime += 1
    #             i -= 1
    #         else:
    #             break;        
    #     return leastIntervalTime if length <= leastIntervalTime else length

    # 优化算法，不用排序在计算任务数量时就得到最大任务数以及和最大任务数相同的任务数量
    def leastInterval(self, tasks: List[str], n: int) -> int:
        ength = len(tasks)
        if length <= 1:
            return length

        maxTaskLength = 0
        maxTaskCount = 0
        map = [0] * 26
        for task in tasks:
            index = ord(task) - ord('A')
            map[index] += 1
            if map[index] == maxTaskLength:
                maxTaskCount += 1
            if map[index] > maxTaskLength:
                maxTaskLength = map[index]
                maxTaskCount = 1
        leastIntervalTime = (maxTaskLength - 1) * (n+1) + maxTaskCount
        return leastIntervalTime if length <= leastIntervalTime else length