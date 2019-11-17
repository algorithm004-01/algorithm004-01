package minimum_window_substring;

import org.omg.CORBA.INTERNAL;

import java.util.HashMap;

/**
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。

 示例：

 输入: S = "ADOBECODEBANC", T = "ABC"
 输出: "BANC"
 说明：

 如果 S 中不存这样的子串，则返回空字符串 ""。
 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 *
 * */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if(s == null || s.length()==0 || t == null || t.length() == 0) return "";
        //使用双指针思路解决
        int[] map = new int[128];
        for(char c: t.toCharArray()) map[c]++;
        int counter=t.length(), begin=0, end=0, d=Integer.MAX_VALUE, head=0;
        while(end<s.length()){
            System.out.print(map[s.toCharArray()[end++]]-->0);
            if(map[s.toCharArray()[end++]]-->0) counter--; //in t
            while(counter==0){ //valid
                if(end-begin<d)  d=end-(head=begin);
                if(map[s.toCharArray()[begin++]]++==0) counter++;  //make it invalid
            }
        }
        return d== Integer.MAX_VALUE? "":s.substring(head, head+d);
    }
    public String minWindow2(String s, String t) {
        //采用双指针去处理
        if(s == null || s.length()==0 || t == null || t.length() == 0) return "";
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c : t.toCharArray()){
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else{
                map.put(c,1);
            }
        }
        int left = 0;
        int minLeft = 0;
        int minLen = s.length()+1;
        int count = 0;
        for(int right = 0; right < s.length(); right++){
            if(map.containsKey(s.charAt(right))){
                map.put(s.charAt(right),map.get(s.charAt(right))-1);
                if(map.get(s.charAt(right)) >= 0){
                    count ++;
                }
                while(count == t.length()){
                    if(right-left+1 < minLen){
                        minLeft = left;
                        minLen = right-left+1;
                    }
                    if(map.containsKey(s.charAt(left))){
                        map.put(s.charAt(left),map.get(s.charAt(left))+1);
                        if(map.get(s.charAt(left)) > 0){
                            count --;
                        }
                    }
                    left ++ ;
                }
            }
        }
        if(minLen>s.length()) return "";
        return s.substring(minLeft,minLeft+minLen);
    }
    public static void main(String[] args){
        MinimumWindowSubstring ms = new MinimumWindowSubstring();
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(ms.minWindow(s,t));
    }
}
