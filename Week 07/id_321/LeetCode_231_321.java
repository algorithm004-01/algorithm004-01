package week07;

public class IsPowerOfTwo231 {

	//2��n���ݱ����������һ��1�����λ��
	public boolean isPowerOfTwo(int n) {
		return n > 0 && (n & (n - 1)) == 0;

	}
}
