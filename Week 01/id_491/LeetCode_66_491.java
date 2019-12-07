class plusOne {
    public int[] plusOne(int[] digits) {
        boolean hasNotNine = false;
        for (int i = digits.length - 1;i >= 0; i--) {
            if(digits[i] != 9){
                digits[i] = digits[i] + 1;
                hasNotNine = true;
                break;
            } else {
                digits[i] = 0;
            }
        }

        if(!hasNotNine){
            int[] result = new int[digits.length + 1];
            for(int i = 0; i < result.length; i++){
                 if(i == 0){
                     result[i] = 1;
                 } else {
                     result[i] = 0;
                 }
            }
            return result;
        } else {
            return digits;
        }
    }
}
