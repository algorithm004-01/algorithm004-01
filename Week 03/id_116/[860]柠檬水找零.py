#在柠檬水摊上，每一杯柠檬水的售价为 5 美元。 
#
# 顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。 
#
# 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。 
#
# 注意，一开始你手头没有任何零钱。 
#
# 如果你能给每位顾客正确找零，返回 true ，否则返回 false 。 
#
# 示例 1： 
#
# 输入：[5,5,5,10,20]
#输出：true
#解释：
#前 3 位顾客那里，我们按顺序收取 3 张 5 美元的钞票。
#第 4 位顾客那里，我们收取一张 10 美元的钞票，并返还 5 美元。
#第 5 位顾客那里，我们找还一张 10 美元的钞票和一张 5 美元的钞票。
#由于所有客户都得到了正确的找零，所以我们输出 true。
# 
#
# 示例 2： 
#
# 输入：[5,5,10]
#输出：true
# 
#
# 示例 3： 
#
# 输入：[10,10]
#输出：false
# 
#
# 示例 4： 
#
# 输入：[5,5,10,10,20]
#输出：false
#解释：
#前 2 位顾客那里，我们按顺序收取 2 张 5 美元的钞票。
#对于接下来的 2 位顾客，我们收取一张 10 美元的钞票，然后返还 5 美元。
#对于最后一位顾客，我们无法退回 15 美元，因为我们现在只有两张 10 美元的钞票。
#由于不是每位顾客都得到了正确的找零，所以答案是 false。
# 
#
# 
#
# 提示： 
#
# 
# 0 <= bills.length <= 10000 
# bills[i] 不是 5 就是 10 或是 20 
# 
# Related Topics 贪心算法



#leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def lemonadeChange(self, bills):
        """
        :type bills: List[int]
        :rtype: bool
        """
        five = ten = 0
        for i in bills:
            if i == 5: five += 1
            elif i == 10: five, ten = five - 1, ten + 1
            elif ten > 0: five, ten = five - 1, ten - 1
            else: five -= 3
            if five < 0: return False
        return True
        
#leetcode submit region end(Prohibit modification and deletion)
