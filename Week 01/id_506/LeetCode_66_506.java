class Solution {
    public int[] plusOne(int[] digits) {
        int index = -1;

        for (int i = digits.length -1 ;i > -1; i--){

            if (digits[i] != 9){
                index = i;
                break;
            }

        }
        
        if (index == -1){
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            for (int i = 1; i < digits.length + 1; i++){
                result[i] = 0;
            }
            return result;

        }

        digits[index]++;
        for (int i = index+1; i < digits.length; i++){
            digits[i] = 0;
        }

        return digits;
    }


    public int[] plusOne1(int[] digits) {
        for (int i = digits.length - 1; i >=0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                break;
            } else {
                digits[i] = 0;
            }
        }
        if (digits[0] == 0) {
            int[] res = new int[digits.length+1];
            res[0] = 1;
            return res;
        }
        return digits;
    }
}