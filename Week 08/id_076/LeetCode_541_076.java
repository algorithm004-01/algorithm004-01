/**
 * 翻转字符串
 *
 */
public class LeetCode_541_076 {

    public String reverseStr(String s, int k) {
        char[] s_arr = s.toCharArray();

        for(int i = 0;i < s_arr.length;){
            //反转k
            if(i + k >= s_arr.length){
                reverseArr(s_arr,i,s_arr.length - 1);
                break;
            }else{
                reverseArr(s_arr,i,i + k-1);
            }
            i += k;

            //跳过k
            if(i + k >= s_arr.length){
                break;
            }
            i += k;
        }
        return String.valueOf(s_arr);
    }

    public void reverseArr(char[] arr , int from , int end){
        for(int i = from , j = end; i < j;i++ , j--){
            char t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }
    }
}



