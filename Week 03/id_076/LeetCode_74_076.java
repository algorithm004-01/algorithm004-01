package week3;

/**
 * 采二分查找搜索二维矩阵
 *  解题思路：
 *  1. 采用暴力方法
 *  2. 转换为有序数组之后，进行二分查找
 *  3. 由于该矩阵正好符合有序数组，可以直接转换为虚数组进行查询，节省空间
 *  4. 采用行首或行尾进行匹配，确认数据可能在哪一行，之后再进行行内进行轮询或二分查找
 *
 *  本题采用虚拟数组方式进行解题
 *
 * @author tangzhenhua
 * @date 2019/11/03 20:00
 */
public class LeetCode_74_076 {

    public boolean searchMatrix(int[][] matrix, int target) {

        int row = matrix.length;
        int col = matrix[0].length;

        int left = 0;
        int right = row * col - 1;

        while (left <= right){
            int idx = (left + right)/2;
            int result = matrix[idx / row][idx % row];
            if(target == result){
                return true;
            } else if(target < result){
                right = idx - 1;
            } else {
                left = idx + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}