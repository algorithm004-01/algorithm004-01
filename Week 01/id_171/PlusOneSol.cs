using System;

namespace Poplar.Algorithm.WeekOne
{
    /// <summary>
    /// 加一
    /// https://leetcode.com/problems/plus-one/
    /// https://leetcode-cn.com/problems/plus-one/
    /// </summary>
    public class PlusOneSol
    {
        public int[] PlusOne(int[] digits)
        {
            //return this.PlusOneOne(digits);
            return this.PlusOneTwo(digits);
        }

        private int[] PlusOneTwo(int[] digits)
        {
            for (int i = digits.Length - 1; i > -1; i--)
            {
                digits[i] = digits[i] + 1;
                digits[i] = digits[i] % 10;
                if (digits[i] != 10)
                {
                    return digits;
                }
            }
            digits = new int[digits.Length + 1];
            digits[0] = 1;
            return digits;
        }

        private int[] PlusOneOne(int[] digits)
        {
            var step = 1;
            for (int i = digits.Length - 1; i > -1; i--)
            {
                var sum = digits[i] + step;
                if (sum > 9)
                {
                    step = 1;
                    sum = sum - 10;
                }
                else
                {
                    step = 0;
                }
                digits[i] = sum;
            }
            if (step == 0)
            {
                return digits;
            }
            var arr = new int[digits.Length + 1];
            arr[0] = step;
            Array.Copy(digits, 0, arr, 1, digits.Length);
            return arr;
        }
    }
}
