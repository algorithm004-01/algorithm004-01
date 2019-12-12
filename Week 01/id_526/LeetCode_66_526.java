class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return null;
        }
        int length = digits.length;
        for (int i = length-1; i >= 0; i--) {
            int value = digits[i];
            if (value < 9) {
                digits[i] = value + 1;
                break;
            }else {
                digits[i] = 0;
            }
            if (i == 0) {
                digits = new int[length+1];
                digits[0] = 1;
            }
        }
        return digits;
    }
}