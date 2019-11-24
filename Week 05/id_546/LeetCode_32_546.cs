using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Hard
{
    /// <summary>
    /// 32. 最长有效括号
    /// </summary>
    public class LongestValidParentheses
    {
        public int LongestValidParentheses1(string s)
        {
            Stack<int> stack = new Stack<int>();
            int max = 0;
            int left = -1;
            for (int j = 0; j < s.Length; j++)
            {
                if (s[j] == '(')
                {
                    stack.Push(j);
                }
                else
                {
                    if (!stack.Any())
                    {
                        left = j;
                    }
                    else
                    {
                        stack.Pop();
                        if (!stack.Any())
                        {
                            max = Math.Max(max, j - left);
                        }
                        else max = Math.Max(max, j - stack.Peek());
                    }
                }
            }
            return max;
        }
    }
}
