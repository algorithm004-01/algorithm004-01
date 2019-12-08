package easy;

/**
 * @author 潘磊明
 * @date 2019/11/5
 */
public class Sqrt_x {
    /**
     * 二分查找
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        long cur = x;
        while (cur * cur > x) {
            cur = (cur + x / cur) / 2;
        }
        return (int)cur;
    }
}
