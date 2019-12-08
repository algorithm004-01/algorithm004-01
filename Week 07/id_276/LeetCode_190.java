public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
         //方法1
        // int result = 0;
        // for (int i = 0; i <= 32; i++) {
        //     // int tmp = n >> i;
        //     // tmp = tmp & 1;
        //     // tmp = tmp << (31 - i);
        //     // result |= tmp;
        //     result |=(((n >> i) & 1) << (31-i));
        // }
        // return result;
	//方法2
        // int res = 0;
        // for (int i = 0; i < 32; ++ i) {
        //     int temp = n >> i;
        //     temp = temp & 1;
        //     if (temp == 0) continue; 
        //     temp = temp <<(31 - i);
        //     res |= temp;
        // }
        // return res;
	//方法3
        //  int ret=n;
        // ret = ret >>> 16 | ret<<16;
        // ret = (ret & 0xff00ff00) >>> 8 | (ret & 0x00ff00ff) << 8;
        // ret = (ret & 0xf0f0f0f0) >>> 4 | (ret & 0x0f0f0f0f) << 4;
        // ret = (ret & 0xcccccccc) >>> 2 | (ret & 0x33333333) << 2;
        // ret = (ret & 0xaaaaaaaa) >>> 1 | (ret & 0x55555555) << 1;
        // return ret;
	//方法4 实现代码与方法3相同
        return Integer.reverse(n);
    }
}