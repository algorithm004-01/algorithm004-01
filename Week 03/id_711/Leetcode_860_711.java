package Week3;

public class Leetcode_860_711 {
    public static void main(String[] args) {
        int[] bills = {5,5,10,10,20};
        System.out.println(lemonadeChange1(bills));
    }

    /**
     * 国际站简洁写法
     * @param bills
     * @return
     */
    private static boolean lemonadeChange1(int[] bills) {
        int five = 0, ten = 0;
        for (int i : bills) {
            if (i == 5) five++;
            else if (i == 10) {five--; ten++;}
            else if (ten > 0) {ten--; five--;}
            else five -= 3;
            if (five < 0) return false;
        }
        return true;
    }

    /**
     * 简单贪心
     * 执行用时 :2 ms, 在所有 java 提交中击败了100.00%的用户
     * 内存消耗 :39.3 MB, 在所有 java 提交中击败了93.65%的用户
     * @param bills
     * @return
     */
    private static boolean lemonadeChange(int[] bills) {
        int fiveNumber = 0, tenNumber = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                fiveNumber++;
            }
            else if (bills[i] == 10) {
                if (fiveNumber < 1)
                    return false;
                tenNumber++;
                fiveNumber--;
            }
            else {
                if (tenNumber > 0 && fiveNumber > 0) {
                    tenNumber--;
                    fiveNumber--;
                }
                else if (fiveNumber > 2) {
                    fiveNumber -= 3;
                }
                else return false;
            }
        }
        return true;
    }
}
