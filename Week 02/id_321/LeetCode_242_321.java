package paixv;

import java.util.Arrays;
import java.util.HashMap;

public class IsAnagram242 {
/*
 * ����1������int�����飬sArray��tArray��������s��t�ַ����е��ַ������a��Ӧ�����±�0��b��Ӧ�����±�1��
 *	���Ƚ������������������
 * ����2��HashMap
 * ����3��java�Դ�Arrays��������
 */
	public boolean isAnagra1(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		int[] sArray = new int[26];
		int[] tArray = new int[26];
		for (int i = 0; i < s.length(); i++) {
			sArray[s.charAt(i) - 97]++;
			tArray[t.charAt(i) - 97]++;
		}
		for (int i = 0; i < 26; i++) {
			if (sArray[i] != tArray[i]) {
				return false;
			}
		}
		return true;
	}

	@SuppressWarnings("unlikely-arg-type")
	public boolean isAnagram2(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < str1.length(); i++) {
			map.put(str1.charAt(i), map.getOrDefault(str1.charAt(i), 0) + 1);
		}
		for (int j = 0; j < str2.length(); j++) {
			if (map.containsKey(str2.charAt(j)) && map.get(str2.charAt(j)) > 0) {
				map.put(str2.charAt(j), map.get(str2.charAt(j)) - 1);
			} else {
				return false;
			}
		}
		return true;

	}

	public boolean isAnagram3(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}
		char[] ch1 = str1.toCharArray();
		char[] ch2 = str2.toCharArray();
		Arrays.sort(ch1);
		Arrays.sort(ch2);
		
		
		return Arrays.equals(ch1, ch2);

	}

	public static void main(String[] args) {

		IsAnagram242 test = new IsAnagram242();
		String str1 = "anagram";
		String str2 = "nagaram";
		System.out.println(test.isAnagram3(str1, str2));
	}
}
