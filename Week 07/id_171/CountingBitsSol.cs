namespace Poplar.Algorithm.WeekSeven
{
    /// <summary>
    /// 比特位计数
    /// https://leetcode.com/problems/counting-bits
    /// https://leetcode-cn.com/problems/counting-bits
    /// </summary>
    public class CountingBitsSol
    {
        /// <summary>
        /// 比特位计数
        /// 时间复杂度O(n)。
        /// n & (n - 1)是打掉最低位的1，所以n比n & (n - 1)多一个1。
        /// </summary>
        /// <param name="num"></param>
        /// <returns></returns>
        public int[] CountBits(int num)
        {
            var container = new int[num < 0 ? 1 : num + 1];
            for (int i = 1; i < num + 1; i++)
            {
                container[i] = container[i & (i - 1)] + 1;
            }
            return container;
        }
    }
}
