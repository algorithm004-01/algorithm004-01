package week01;

//ֻ�е�ĩβ�н�λʱ������λ�ſ��ܽ�λ
public class PlusOne66 {

	public int[] plusOne(int[] digits) {
		int len = digits.length;
		for (int i = len - 1; i >= 0; i--) {
			digits[i]++;
			digits[i] %= 10;
			if (digits[i] != 0) {
				return digits;
			}
		}
		digits = new int[len + 1];
		digits[0] = 1;
		return digits;
	}
}
