namespace Poplar.Algorithm.WeekSeven
{
    /// <summary>
    /// 位1的个数
    /// https://leetcode.com/problems/number-of-1-bits
    /// https://leetcode-cn.com/problems/number-of-1-bits
    /// </summary>
    public class NumberOf1BitsSol
    {
        public int HammingWeight(uint n)
        {
            var count = 0;
            while (n > 0)
            {
                count++;
                n = n & (n - 1);
            }
            return count;
        }

        /// <summary>
        /// O(n)的时间复杂度
        /// </summary>
        /// <param name="n"></param>
        /// <returns></returns>
        public int HammingWeightOne(uint n)
        {
            var count = 0;
            while (n > 0)
            {
                if ((n & 1) > 0)
                {
                    count++;
                }
                n = n >> 1;
            }
            return count;
        }
    }
}
