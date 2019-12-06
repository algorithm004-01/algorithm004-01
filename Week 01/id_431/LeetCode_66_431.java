package simple;

/**
 * @author 潘磊明
 * @date 2019/10/22
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        boolean isAllNine = true;
        for (int i = digits.length - 1; i > -1; i--) {
            if (digits[i] != 9) {
                digits[i] = digits[i] + 1;
                return digits;
            }else {
                digits[i] = 0;
            }
        }
        if (isAllNine) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            for (int i = 1; i < newDigits.length; i++){
                newDigits[i] = 0;
            }
            return newDigits;
        }
        return null;
    }
}
