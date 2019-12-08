//第一个不重复字符 hashmap 
public int firstUniqChar(String s) {
       Map<Character, Integer> map = new HashMap<>();
       for (int i = 0; i < s.length(); ++ i) {
           if (map.containsKey(s.charAt(i))) map.put(s.charAt(i), -1);
           else map.put(s.charAt(i), i);
       }
       for (char c : s.toCharArray()) {
           if (map.get(c) >= 0) return map.get(c);
       }
       return -1;
    }
//int[]
public int firstUniqChar(String s) {
	int[] freq = new int[26];
	for (int i = 0; i < s.length(); ++ i) freq[s.charAt(i) - 'a'] ++;
	for (int i = 0; i < s.length(); ++ i) {
		if (freq[s.charAt(i) - 'a'] == 1) return i;
	}
}
