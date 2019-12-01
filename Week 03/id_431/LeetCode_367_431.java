package easy;

/**
 * @author 潘磊明
 * @date 2019/11/5
 */
public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        long cur = num;
        while (cur * cur > num) {
            cur = (cur + num /cur) / 2;
        }
        return cur * cur == num;
    }
}
