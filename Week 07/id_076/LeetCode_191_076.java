/**
 *  1. 循环和位移
 *     使用 & 操作 ！= 0 确认二进制位是否为1
 *  2. 消除最后的1
 *
 */
public class LeetCode_191_076 {

    public int hammingWeight(int n) {
        int size = 0;
        int mark = 1;

        for(int i = 0; i < 32; i++){
            if((n & mark) != 0) {
                size ++;
            }
            mark <<= 1;
        }
        return size;
    }

    public int hammingWeight2(int n) {
        int size = 0;
        while(n != 0){
            size ++;
            n &= (n - 1);
        }
        return size;
    }

    public static void main(String[] args) {
        LeetCode_191_076 leetCode = new LeetCode_191_076();
        int size = leetCode.hammingWeight(3);
        System.out.println(size);

        int size2 = leetCode.hammingWeight2(3);
        System.out.println(size2);

    }
}
