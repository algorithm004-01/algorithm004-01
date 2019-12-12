class Solution {
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        //去掉s的首尾空格 然后将字符串拆分
        String[] s1 = s.trim().split(" ");
        for(int i = s1.length - 1; i >= 0; i--){
            //空格后面的空格会变成空字符串
            if(!s1[i].equals("")) ans.append(s1[i] + " ");
        }
        //去掉最后添加上的空格
        ans = new StringBuilder(ans.toString().trim());
        return ans.toString();
    }
}