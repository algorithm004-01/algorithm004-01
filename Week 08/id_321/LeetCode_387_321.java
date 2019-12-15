package week08;

import java.util.HashMap;

public class Solution387 {

	public int firstUniqChar(String s) {

		int array[] = new int[26];
		for (char ch : s.toCharArray()) {
			array[ch - 'a']++;
		}
		for (int i = 0; i < s.length(); i++) {
			if (array[s.charAt(i) - 'a'] == 1) {
				return i;
			}
		}
		return -1;
	}

	public int firstUniqChar2(String s) {
		HashMap<Character, Integer> count = new HashMap<Character, Integer>();
		int n = s.length();

		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			count.put(c, count.getOrDefault(c, 0) + 1);
		}

		for (int i = 0; i < n; i++) {
			if (count.get(s.charAt(i)) == 1)
				return i;
		}
		return -1;
	}

}
