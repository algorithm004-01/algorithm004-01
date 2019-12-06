namespace Poplar.Algorithm.WeekThree
{
    /// <summary>
    /// 搜索二维矩阵
    /// https://leetcode.com/problems/search-a-2d-matrix/
    /// https://leetcode-cn.com/problems/search-a-2d-matrix/
    /// </summary>
    public class SearchA2dMatrixSol
    {
        /// <summary>
        /// 二分法
        /// </summary>
        /// <param name="matrix"></param>
        /// <param name="target"></param>
        /// <returns></returns>
        public bool SearchMatrix(int[][] matrix, int target)
        {
            if (matrix == null || matrix.Length == 0)
            {
                return false;
            }
            var width = matrix[0].Length;
            var lo = 0;
            var hi = width * matrix.Length - 1;
            while (lo <= hi)
            {
                var mid = (lo + hi) / 2;
                var cur = matrix[mid / width][mid % width];
                if (cur == target)
                {
                    return true;
                }
                else if (cur > target)
                {
                    hi = mid - 1;
                }
                else
                {
                    lo = mid + 1;
                }
            }
            return false;
        }
    }
}
