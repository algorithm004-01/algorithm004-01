/**
 * PlusOne
 * <p>
 * 方法名为-> plusOne 为最终解法
 * 除此以外为独立完成时,自己的解法,主要在于对比
 */
public class PlusOne {

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }

    public static int[] plusOneOriginal(int[] digits) {
        boolean addSpace = true;
        for (int i = 0; i < digits.length; i++)
            if (digits[i] != 9) {
                addSpace = false;
                break;
            }

        int[] res;
        if (addSpace) {
            res = new int[digits.length + 1];
            for (int i = 1; i < digits.length + 1; i++)
                res[i] = digits[i - 1];
        } else {
            res = new int[digits.length];
            for (int i = 0; i < digits.length; i++)
                res[i] = digits[i];
        }

        boolean carry = true;
        for (int i = res.length - 1; i >= 0; i--) {
            if (carry) {
                int temp = res[i];
                res[i] += 1;
                res[i] %= 10;
                carry = res[i] < temp;
            } else
                break;
        }
        return res;
    }
}