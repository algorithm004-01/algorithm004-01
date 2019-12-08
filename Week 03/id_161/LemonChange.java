class Solution {
    public boolean lemonadeChange(int[] bills) {
        int c5=0;
        int c10=0;
        for(int bill:bills){
            if(bill==5)
                c5+=5;
            else if(bill==10){
                if(c5!=0){
                    c5-=5;
                    c10+=10;
                }else  return false;
                
            }else if(c10!=0){
                    if(c5!=0){
                        c5-=5;
                        c10-=10;   
                    }else return false;
                }else if(c5>=15)
                        c5-=15;
                    else return false;
        }
        return true;
    }
}