public class PlusOne {
    public int[] plusOne(int[] digits) /*{
        int tar = 1;

        for (int i=digits.length-1;i>=0;--i) {
            int sum = digits[i]+tar;
            if (sum > 10) {
                digits[i] = digits[i]%10;
                tar = 1;
            } else {
                digits[i] = sum;
                tar = 0;
                break;
            }
        }
        int[] temp;
        if (tar == 1) {
            temp = new int[digits.length+1];
            temp[0] = 1;
            System.arraycopy(nums, 0, temp, 1,digits.length);
        } else {
            temp = new int[digits.length];
            System.arraycopy(nums, 0, temp, 0, digits.length);
        }
        return temp;
    }*/
    /*public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];https://leetcode.com/problems/climbing-stairs/
        digits[0] = 1;
        return digits;
    }*/
}
