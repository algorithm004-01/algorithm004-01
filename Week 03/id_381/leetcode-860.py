"""
这个题在解决的时候，顾客给5的时候最好解决了，直接加上就行，10的时候也很好解决，
只有一种找钱的方式就是找5元返给顾客(注意five-1了，ten要+1)。需要注意的是，顾客给20元的时候，
最优的理解为给10+5，但是这也不是一定的，如果没有10却有3个5， 那么就需要考虑到了。
需要注意20的找钱方式
"""

class Solution:
    def lemonadeChange(self, bills) -> bool:
        five, ten = 0, 0
        for bill in bills:
            if bill == 5: five += 1
            elif bill == 10: five, ten = five-1, ten+1
            elif ten: five, ten = five-1, ten-1
            else: five -= 3
            if five < 0:
                return False
        return True
