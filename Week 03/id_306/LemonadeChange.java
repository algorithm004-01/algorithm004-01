/**
 * Created by LynnSun on 2019/10/31.
 * 力扣题目地址：https://leetcode-cn.com/problems/lemonade-change/description/
 */
public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int money_five=0;
        int money_ten=0;
        for (int bill :bills) {
            if(5==bill){
                money_five++;
            }else if (10==bill){
                if(money_five==0){
                    return false;
                }
                money_five--;
                money_ten++;
            }else{
                // 这样才是贪心 先考虑10元再考虑5元
                if(money_ten>0 && money_five>0){
                    money_ten--;
                    money_five--;
                }else if(money_five>2){
                    money_five=money_five-3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}
