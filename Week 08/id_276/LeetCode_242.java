//LeetCode 242 
//��Ч��λ��
public boolean isAnagram(String s, String t) {
        int[] cnt = new int[255];
        for(char c : s.toCharArray()) cnt[c - 'a'] ++;
        for (char c : t.toCharArray()) cnt[c - 'a'] --;
        for (int n : cnt) if (n != 0) return false;
        return true;
    }