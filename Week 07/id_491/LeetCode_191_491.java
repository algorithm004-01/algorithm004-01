public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        long temp = n;
        if(temp < 0) {
            temp = (Integer.MAX_VALUE + 1L) * 2L + temp;
        }
        
        int result = 0;
        while(temp != 0) {
            result += temp % 2;
            temp = temp >> 1 ;
        }

        return result;
    }
}
