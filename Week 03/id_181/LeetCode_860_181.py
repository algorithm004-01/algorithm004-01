# [860. 柠檬水找零 - 力扣（LeetCode）](https://leetcode-cn.com/problems/lemonade-change/description/)
# 5 元时 获取一张
# 10元时 需要减去一个5元，若有则减去，若没有则返回False
# 15...  可以10 + 5，或者 5*3 找零，数目满足则成功
# 需要对 5 和 10 的数目保存，20不用是因为找零用不上
class Solution:
    def lemonadeChange(self, bills: List[int]) -> bool:
        five = ten = 0
        for bill in bills:
            if bill == 5:
                five +=1
            elif bill == 10:
                if not five:
                    return False
                five -= 1
                ten += 1
            else:
                if ten and five:
                    ten -= 1
                    five -= 1
                elif five >=3:
                    five-=3
                else:
                    return false
        return True