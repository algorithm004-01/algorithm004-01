package com;

/**
 * @auther: TKQ
 * @Title: IsAnagram_242
 * @Copyright: Copyright (c) 2019
 * @Description:
 * @Company:
 * @Created: 2019-11-02 10:02
 */
public class IsAnagram_242 {

    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        char[] s_array = s.toCharArray();
        char[] t_array = t.toCharArray();
        int[] temp = new int[26];
        for (int i = 0; i < s.length(); i++) {
            temp[s.charAt(i) - 'a']++;
            temp[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < temp.length; i++) {
            if(temp[i]!=0){
                return false;
            }
        }
        return true;
    }
}
