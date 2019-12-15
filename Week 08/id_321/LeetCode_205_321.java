package week08;

public class Solution205 {

	class Solution {
		public boolean isIsomorphic(String s, String t) {
			char[] ch1 = s.toCharArray();
			char[] ch2 = t.toCharArray();
			int len = s.length();
			for (int i = 0; i < len; i++) {
				if (s.indexOf(ch1[i]) != t.indexOf(ch2[i])) {
					return false;
				}
			}
			return true;
		}
	}

}
