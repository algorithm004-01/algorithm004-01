# 柠檬水找零
# 1、先判断数组中的第一个、第二个元素，如果第一个元素不是 5 直接返回false，如果第二个元素是 20 ，直接返回 false，
# 2、之后再循环判断数组中的元素，记录出现 5、10 元素的次数，循环累计，后续出现的元素与累计的 5、10 元素去做比较，如果不能找零，则返回 false 注：元素只能是为 5、10、20 


class Solution {
    public boolean lemonadeChange(int[] bills) {
        int countFive = 0;
        int countTen = 0;
        for (int bill : bills) {
            if ( bill == 5) {
                countFive ++;
            }else if( bill == 10) {
                if ( countFive == 0) {
                    return false;
                }
                countFive --;
                countTen ++;
            }else {
                if (countFive > 0 && countTen > 0) {
                    countFive--;
                    countTen--;
                } else if (countFive >= 3) {
                    countFive -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;        
    }
}

