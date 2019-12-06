/**
 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。

 顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。

 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。

 注意，一开始你手头没有任何零钱。

 如果你能给每位顾客正确找零，返回 true ，否则返回 false 。

 示例 1：

 输入：[5,5,5,10,20]
 输出：true
 解释：
 前 3 位顾客那里，我们按顺序收取 3 张 5 美元的钞票。
 第 4 位顾客那里，我们收取一张 10 美元的钞票，并返还 5 美元。
 第 5 位顾客那里，我们找还一张 10 美元的钞票和一张 5 美元的钞票。
 由于所有客户都得到了正确的找零，所以我们输出 true。
 示例 2：

 输入：[5,5,10]
 输出：true
 示例 3：

 输入：[10,10]
 输出：false
 示例 4：

 输入：[5,5,10,10,20]
 输出：false
 解释：
 前 2 位顾客那里，我们按顺序收取 2 张 5 美元的钞票。
 对于接下来的 2 位顾客，我们收取一张 10 美元的钞票，然后返还 5 美元。
 对于最后一位顾客，我们无法退回 15 美元，因为我们现在只有两张 10 美元的钞票。
 由于不是每位顾客都得到了正确的找零，所以答案是 false。
  

 提示：

 0 <= bills.length <= 10000
 bills[i] 不是 5 就是 10 或是 20 

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/lemonade-change
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_22_416{
    //这道题目是在贪心的科目下面，一开始也不明白为什么是贪心，贪心的意思是：当前是最优解，最后我好像有点明白了，在写代码的过程中，如果当前是最优解那么就返回
    //复习了一下switch的用法，break必须要加上，如果bill=5，如果在case = 5的情况下，不加入break，下面的所有case都会执行，所以swtich case语句是直接跳到指定参数值以后的地方，如果不加break的话
    public boolean lemonadeChange(int[] bills) {
        int five = 0,ten = 0;
        for (int bill : bills){
            switch(bill) {
                case 5:
                    five++;break;
                case 10:
                    if(five-- == 0) return false;
                    ten++;break;
                case 20:
                     if(ten >= 1 && five >= 1) {five--;ten++;break;}
                     if(five >= 3) {five = five - 3;break;}
                     return false;
            }
        }
        return true;
    }
}