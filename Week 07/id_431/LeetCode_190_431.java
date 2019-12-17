package easy;

/**
 * @author 潘磊明
 * @date 2019/11/30
 */
public class ReverseBits {
    public int reverseBits(int n) {
        int result = 0;
        for(int i = 0;i < 32;i++){
            result = (result << 1) + (n & 1);
            n >>= 1;
        }
        return result >>> 0;
    }
}
