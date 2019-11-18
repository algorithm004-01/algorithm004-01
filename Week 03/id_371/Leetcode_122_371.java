/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-11-01 07:57
 **/

public class Leetcode_122_371 {

    public static void main(String[] args) {
//        int[] prices = {7, 6, 4, 3, 1};
//        int[] prices = {1, 2, 3, 4, 5};
        int[] prices = {1, 2, 5, 3, 4};
        int profit = maxProfit2(prices);
        System.out.println(profit);
    }

    /**
     * 原解2:累加每段上升的利润
     *
     * @author Shaobo.Qian
     * @date 2019/11/1
     */
    public static int maxProfit2(int[] prices) {
        if (prices.length == 0 || prices.length == 1) return 0;
        int sum = 0;
        int min = 0;
        int max = 0;
        boolean flag = true;//是否处于上升
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[i - 1]) {
                if (flag && max > min) {
                    sum += (prices[max] - prices[min]);
                }
                min = i;
                flag = false;
            } else {
                flag = true;
                max = i;
            }
            if (flag && i == prices.length - 1 && (max > min)) {
                sum += (prices[max] - prices[min]);
            }
        }
        return sum;
    }

    /**
     * 原解1:暴力法
     *
     * @author Shaobo.Qian
     * @date 2019/11/1
     */
    public static int maxProfit1(int[] prices) {
        if (prices.length == 0 || prices.length == 1) return 0;
        int profit = 0;
        //22比较,当后面的数大于前面的数就产生了利润
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) profit += (prices[i] - prices[i - 1]);
        }
        return profit;
    }

}
