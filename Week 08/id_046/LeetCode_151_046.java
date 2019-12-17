class Solution {
    public String reverseWords(String s) {
        String emptyStr=" ";
        final String[] words = s.trim().split(emptyStr);
        StringBuilder sb=new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            String str=words[i];
           while (str.contains(emptyStr)){
               str=str.replaceAll(emptyStr,"");
           }
            if ("".equals(str)){
                continue;
            }
            sb.append(str).append(emptyStr);
        }
        return sb.toString().trim();

    }
}