class Solution {
    public boolean lemonadeChange(int[] bills) {
        //定义收取 5 元 和 10 元的个数
        int five = 0;
        int ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five ++;
            } else if (bill == 10) {
                //判断是否有找零
                if (five == 0) {
                    return fales;
                } else {
                    ten ++;
                    five --;
                }
            } else {
                //判断是否有足够的 5 元和 10 元
                if (five > 0 && ten > 0) {
                    five --;
                    ten --;
                } else if (five >= 3) {
                    // 当有足够的 5 元情况
                    five -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }

}