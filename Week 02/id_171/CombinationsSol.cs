using System.Collections.Generic;

namespace Poplar.Algorithm.WeekTwo
{
    /// <summary>
    /// 组合
    /// https://leetcode.com/problems/combinations/
    /// https://leetcode-cn.com/problems/combinations/
    /// </summary>
    public class CombinationsSol
    {
        public IList<IList<int>> Combine(int n, int k)
        {
            //var result = new List<IList<int>>();
            //Do(n, k, 1, 1, new List<int>(k), result);
            //return result;
            return CombineTwo(n, k);
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="n"></param>
        /// <param name="k"></param>
        /// <returns></returns>
        private IList<IList<int>> CombineTwo(int n, int k)
        {
            var nums = new List<int>();
            for (int i = 1; i < k + 1; ++i)
            {
                nums.Add(i);
            }
            nums.Add(n + 1);
            List<IList<int>> output = new List<IList<int>>();
            int j = 0;
            while (j < k)
            {
                var coll = new List<int>(nums);
                coll.RemoveAt(coll.Count - 1);
                output.Add(coll);
                j = 0;
                while (j < k && nums[j + 1] == nums[j] + 1)
                {
                    nums[j] = j++ + 1;
                }
                nums[j]++;
            }
            return output;
        }

        /// <summary>
        /// 使用回溯。
        /// 假设1到n是所有能使用的数字，k是要组成k个元素的列表
        /// 每一次递归的时候，判断临时容器中数字是否已经够了，如果够了，就加入到结果集中。
        /// 递归方法中有层级和开始数字这两个人重要参数。
        /// 最开始进入代码时，开始数字是1，层级是1，进行循环，此时循环能达到最大数字是n - (k - level)，将循环当前数字加入到临时容器中，
        /// 开始数字和层级加1，进入递归，当前数字的递归结束之后，将当数字移除。
        /// 进入下一个循环
        /// </summary>
        /// <param name="n"></param>
        /// <param name="k"></param>
        /// <param name="start"></param>
        /// <param name="level"></param>
        /// <param name="container"></param>
        /// <param name="result"></param>
        private void Do(int n, int k, int start, int level, List<int> container, IList<IList<int>> result)
        {
            if (container.Count == k)
            {
                var cur = new List<int>(container);
                result.Add(cur);
                return;
            }
            //k - level 是组合中接下来还需要的数字的个数，
            //n - (k - level)则是计算当前循环中能达到的最大数。
            var max = n - (k - level);
            for (var i = start; i <= max; i++)
            {
                container.Add(i);
                Do(n, k, i + 1, level + 1, container, result);
                container.RemoveAt(container.Count - 1);
            }
        }
    }
}
