class Solution {
    public String reverseWords(String s) {
        if("".equals(s)) return "";
        String[] arr = s.split(" ");
        StringBuffer news = new StringBuffer();
        for (int i=0;i<arr.length;i++){
            char[] c = arr[i].toCharArray();
            if (c[0] == ' ') continue;
            int x = 0;
            int y = c.length - 1;
            char t;
            while (x < y){
                t = c[x];
                c[x] = c[y];
                c[y] = t;
                x++;
                y--;
//                if(x == y){
//                    break;
//                }
            }
            news.append(String.valueOf(c) + " ");
        }
        return news.toString().trim();
    }
}
