package week07;

public class ReverseBits190 {

	public int reverseBits1(int n) {
		int result = 0;
		for (int i = 0; i <= 32; i++) {
			
			int tmp = (n >> i) & 1;

			// 2. Ȼ��ͨ��λ���㽫����õ���ת���λ��.
			tmp = tmp << (31 - i);
			// 3. ����������ٴ�ͨ�������ϵ�һ��
			result |= tmp;
		}
		return result;
	}

}
