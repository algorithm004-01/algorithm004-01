package week08;

public class Solution680 {
//��������ָ�룬�ж����������Ƿ���� ������ʱ �������һ���ַ������ұ�����һ���ַ���ֻ������һ��
	public boolean validPalindrome(String s) {
		int left = 0;
		int right = s.length() - 1;// "abca"
		while (left < right) {// ����������left=right��ʱ��
			
			if (s.charAt(left) != s.charAt(right)) {
				return isPalindrome(s, left, right - 1) || isPalindrome(s, left + 1, right);
			}
			// �������ߵ��ַ���ȡ�
			left++;
			right--;
		}
		return true;
	}

	private boolean isPalindrome(String s, int i, int j) {
		while (i < j) {
			if (s.charAt(i++) != s.charAt(j--)) {
				return false;
			}
		}
		return true;
	}

}
