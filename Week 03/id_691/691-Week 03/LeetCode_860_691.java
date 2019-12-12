class Solution {
    public boolean lemonadeChange(int[] bills) {
        if (bills == null || bills.length < 1){
            return true;
        }

        if(bills[0] != 5){
            return false;
        }

        int money[0] = new int[3]; //5 10 15
        money[0]++;

        for(int i = 1; i < bills.length; i++){
            switch (bills[i]){
                case 5:
                    money[0]++;
                    break;

                case 10:
                    money[1]++;
                    money[0]--;

                    if(money[0] < 0){
                        return false;
                    }
                    break;

                case 20:
                    money[2]++;
                    if(money[1] > 0){
                        money[1]--;
                    }else{
                        money[0] -= 2;
                    }

                    money[0]--;

                    if(money[0] < 0){
                        return false;
                    }

                    break;
            }
            return true;
        }
    }
}