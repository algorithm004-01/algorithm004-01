package week07;

public class ReverseBits190 {

	public int reverseBits1(int n) {
		int result = 0;
		for (int i = 0; i <= 32; i++) {
			
			int tmp = (n >> i) & 1;

			// 2. 然后通过位运算将其放置到反转后的位置.
			tmp = tmp << (31 - i);
			// 3. 将上述结果再次通过运算结合到一起
			result |= tmp;
		}
		return result;
	}

}
