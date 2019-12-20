package week07;

public class IsPowerOfTwo231 {

	//2的n次幂必须满足仅有一个1（最高位）
	public boolean isPowerOfTwo(int n) {
		return n > 0 && (n & (n - 1)) == 0;

	}
}
