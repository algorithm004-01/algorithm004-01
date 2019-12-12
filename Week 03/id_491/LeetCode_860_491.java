class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fiveBank = 0;
        int tenBanke = 0;
        for(int i = 0; i < bills.length; i++){
            if(bills[i] == 5){
                fiveBank++;
            } else if(bills[i] == 10){
                if(fiveBank > 0) {
                    fiveBank--;
                    tenBanke++;
                } else {
                    return false;
                }
            } else {
                if(tenBanke > 0 && fiveBank > 0) {
                    fiveBank--;
                    tenBanke--;
                } else if(fiveBank > 2){
                    fiveBank -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
