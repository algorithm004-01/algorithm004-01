class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        StringBuffer b = new StringBuffer();
        for (int i=arr.length-1;i>=0;i--){
            if(!arr[i].equals("")) {
                b.append(arr[i]).append(" ");
            }
        }
        return b.toString().trim();
    }
}
