namespace Poplar.Algorithm.WeekSeven
{
    /// <summary>
    /// 2的幂
    /// https://leetcode.com/problems/power-of-two
    /// https://leetcode-cn.com/problems/power-of-two
    /// </summary>
    public class PowerOfTwoSol
    {
        /// <summary>
        /// 2的幂
        /// </summary>
        /// <param name="n"></param>
        /// <returns></returns>
        public bool IsPowerOfTwo(int n)
        {
            return n > 0 && (n & (n - 1)) == 0;
        }
    }
}
