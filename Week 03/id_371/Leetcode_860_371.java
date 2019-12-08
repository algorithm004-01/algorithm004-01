import java.util.HashMap;
import java.util.Map;

/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-10-31 19:50
 **/

public class Leetcode_860_371 {
    public static void main(String[] args) {
        int[] bills = {5, 5, 5, 5, 20, 20, 5, 5, 20, 5};
//        int[] bills = {5, 5, 10, 10, 20};
        System.out.println(lemonadeChange2(bills));

    }
    /**
     * 优化
     * @author Shaobo.Qian
     * @date 2019/11/1
     */
    public static boolean lemonadeChange2(int[] bills) {

        int fiveCnts = 0, tenCnts = 0;

        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                fiveCnts++;
            } else if (bills[i] == 10) {
                if (fiveCnts == 0) return false;
                fiveCnts--;
                tenCnts++;
            } else {
                if (tenCnts > 0 && fiveCnts > 0) {
                    fiveCnts--;
                    tenCnts--;
                } else if (fiveCnts >= 3) {
                    fiveCnts -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 原解1:贪心法+map
     *
     * @author Shaobo.Qian
     * @date 2019/10/31
     */
    public static boolean lemonadeChange1(int[] bills) {
        //对10来讲,5是可用的对20来件10和5是可用的
        Map<Integer, Integer> map = new HashMap<>();
        map.put(5, 0);
        map.put(10, 0);
        Integer fiveCnts = map.get(5);
        Integer tenCnts = map.get(10);
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                map.put(5, fiveCnts++);
            } else if (bills[i] == 10) {
                if (fiveCnts == 0) return false;
                map.put(5, fiveCnts--);
                map.put(10, tenCnts++);
            } else {
                if (tenCnts == 0) {
                    if (fiveCnts < 3) return false;
                    fiveCnts = fiveCnts - 3;
                    map.put(5, fiveCnts);
                } else {
                    if (fiveCnts == 0) return false;
                    map.put(10, tenCnts--);
                    map.put(5, fiveCnts--);
                }
            }
        }
        return true;
    }

}
