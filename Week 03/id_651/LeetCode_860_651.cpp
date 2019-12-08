/*
在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
注意，一开始你手头没有任何零钱。如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
示例 1：
输入：[5,5,5,10,20]
输出：true
解释：
前 3 位顾客那里，我们按顺序收取 3 张 5 美元的钞票。
第 4 位顾客那里，我们收取一张 10 美元的钞票，并返还 5 美元。
第 5 位顾客那里，我们找还一张 10 美元的钞票和一张 5 美元的钞票。
由于所有客户都得到了正确的找零，所以我们输出 true。

思路： 贪心算法：
    第一位是5元，不用找零
    第二位是10元，找零5元
    第三位是20元，则返回false
    假设前3位都是5元，第三位是10元，第四位是20元，
    则最优的是找零一张五元，一张十元，而不是三张五元
*/
# include <iostream>
# include <windows.h>
# include <vector>
using namespace std;

class Solution {
public:
     bool lemonadeChange(vector<int>& bills){
        int five=0;
        int ten=0;
        int twenty=0;
        int len = bills.size();
        for(int i=0;i<len;i++){
            if(bills[i] ==5) five++;
            else if(bills[i]==10){
                if (five) {five--;ten++;}
                else return false;
            }
            else if(bills[i]==20){
                if(five >0 && ten >0){
                    five--;ten--;twenty++;
                }
                //找3张的要后判断才是最优解
                else if(five>=3) five-=3;
                else return false;
            }
        }
        return true;
     }
}

int main(){
    Solution sol;
    return 0;
}