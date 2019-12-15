package week08;

public class Solution680 {
//左右两个指针，判断左右两边是否相等 当不等时 左边跳过一个字符或者右边跳过一个字符，只能跳过一次
	public boolean validPalindrome(String s) {
		int left = 0;
		int right = s.length() - 1;// "abca"
		while (left < right) {// 结束条件：left=right的时候
			
			if (s.charAt(left) != s.charAt(right)) {
				return isPalindrome(s, left, right - 1) || isPalindrome(s, left + 1, right);
			}
			// 左右两边的字符相等。
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
