using System;
using System.Collections.Generic;

public class Solution
{
    private IList<string> _array;
    public IList<string> GenerateParenthesis(int n)
    {
        _array = new List<string>();
        this.Generate(0, 0, n, "");
        return _array;
    }

    /// <summary>
    /// 
    /// </summary>
    /// <param name="left">左括号使用数量</param>
    /// <param name="right">右括号使用数量</param>
    /// <param name="level">递归层级</param>
    /// <param name="str">当前递归层拼接出的字符串</param>
    private void Generate(int left, int right, int level, string str)
    {
        if (left == level &&  right == level)
        {
            this._array.Add(str);
            return;
        }
        if (left < level)
        {
            this.Generate(left + 1, right, level, str + "(");
        }
        if (right < left)
        {
            this.Generate(left, right + 1, level, str + ")");
        }
    }
}