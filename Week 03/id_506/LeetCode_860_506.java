class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fives = 0;
        int tens = 0;
        
        for(int i : bills){
            
            if (i == 5){
                fives++;
            }
            
            if (i == 10){
                
                if (fives < 1){
                    return false;
                }
                
                tens ++;
                fives --;
                
            }
            
            if (i == 20){
                
                if (tens == 0){
                    if (fives < 3){
                        return false;
                    }
                }
                if (tens > 0){
                    if (fives < 1){
                        return false;
                    }
                }                

                
                if (tens > 0){
                    tens --;
                    fives --;
                    
                }else{
                    fives -= 3;
                }
                
                
            }
            
        }
        return true;
        
    }
}