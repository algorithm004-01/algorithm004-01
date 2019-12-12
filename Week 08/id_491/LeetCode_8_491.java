class Solution {
    public int myAtoi(String str) {
        boolean isMinus = false;
        String result = "";
        if(str == null){
            return 0;
        } else {
            str = str.trim();
            if(str.length() == 0){
                return 0;
            } else if((str.startsWith("-") || str.startsWith("+"))) {
                if((str.length() == 1 || str.charAt(1) < 48 || str.charAt(1) > 57)){
                    return 0;
                } else {
                    isMinus = str.startsWith("-");
                    str = str.substring(1, str.length());
                }
            } else if(str.charAt(0) < 48 || str.charAt(0) > 57){
                return 0;
            } 
            
            for(int i = 0; i < str.length(); i++) {
                if(str.charAt(i) >= 48 && str.charAt(i) <= 57){
                    result += String.valueOf(str.charAt(i));
                } else {
                    break;
                }
            }
            try{
                if(isMinus){
                    return 0 - Integer.valueOf(result);
                } else {
                    return 0 + Integer.valueOf(result);
                }
                
            } catch(Exception ex){
                if(isMinus){
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            }
        }
        
    }
}
