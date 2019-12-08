/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-12-01 15:13
 **/

public class Leetcode_363_371 {

    /**
     * 防解1:暴力法
     *
     * @author Shaobo.Qian
     * @date 2019/12/1
     * @link https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k/comments/
     */
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;

        //1.从左上角起点(0,0)到当前点(row,col)的矩阵面积
        int[][] sum = new int[rows + 1][cols + 1];
        int res = Integer.MIN_VALUE;//k < 0 ,res是负值,所以初始化为Integer.MIN_VALUE
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                sum[i][j] = matrix[i - 1][j - 1] + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
                //2.每个矩阵内的子矩阵面积
                for (int l = 1; l <= i; l++) {
                    for (int m = 1; m <= j; m++) {
                        //子矩阵面积(画图比较好理解)
                        int subMatrixSum = sum[i][j] + sum[l - 1][m - 1] - sum[i][m - 1] - sum[l - 1][j];
                        if (subMatrixSum <= k) {
                            res = Math.max(subMatrixSum, res);
                        }
                    }
                }

            }
        }
        return res;
    }

    /**
     * 防解2:mergesort
     * @author Shaobo.Qian
     * @date 2019/12/1
     * @link https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/discuss/83595/JAVA-117ms-beat-99.81-merge-sort
     */
    public int maxSumSubmatrix1(int[][] matrix, int k) {

        return 0;
    }
}
