package easy;

/**
 * @author 潘磊明
 * @date 2019/11/30
 */
public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        return (n > 0 && (n & n - 1) == 0);
    }
}
