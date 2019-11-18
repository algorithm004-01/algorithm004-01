class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for(int i : bills){
            if(i==5) five++;
            if(i==10){
                if(five == 0) return false;
                else {
                 five--;
                 ten++;   
                }
            }
            if(i==20){
                if(ten > 0 && five > 0 ){
                    ten--;
                    five--;
                }else if(five >2){
                    five = five -3;
                }else return false;
            }
        }
        return true;
    }

    // 更简洁的逻辑，前面的处理保证了不会有负数的10，只需根据5的计数判断是否有足够零钱
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int i : bills) {
            if (i == 5) five++;
            else if (i == 10) {five--; ten++;}
            else if (ten > 0) {ten--; five--;}
            else five -= 3;
            if (five < 0) return false;
        }
        return true;
    }
}