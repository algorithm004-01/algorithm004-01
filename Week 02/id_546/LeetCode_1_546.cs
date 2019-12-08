using System.Collections.Generic;

namespace Easy
{
    /// <summary>
    /// 1. 两数之和
    /// </summary>
    public class TwoSum
    {
        /// <summary>
        /// 暴力法
        /// </summary>
        /// <param name="nums"></param>
        /// <param name="target">目标</param>
        /// <returns></returns>
        public static int[] TwoSum1(int[] nums, int target)
        {
            //因为要返回数组下标，因此不能打乱数组的顺序

            //[1,2,3,4,5,6]

            for (int i = 0; i < nums.Length; i++)
            {
                for (int j = i + 1; j < nums.Length; j++)
                {
                    if (nums[i] + nums[j] == target)
                        return new[] { i, j };
                }
            }
            return new int[] { };
        }

        //方法二
        public static int[] TwoSum2(int[] nums, int target)
        {
            //将数组转换为键值对
            for (int i = 0; i < nums.Length; i++)
            {
                int dif = target - nums[i];
                for (int j = 0; j < i; j++)
                {
                    if (nums[i] == nums[j])
                    {
                        return new[] { i, j };
                    }
                }
                nums[i] = dif;
            }

            return new int[] { };
        }

        /// <summary>
        /// 最快解法
        /// </summary>
        /// <param name="nums"></param>
        /// <param name="target"></param>
        /// <returns></returns>
        public static int[] TwoSum3(int[] nums, int target)
        {
            //因为要返回数组下标，因此不能打乱数组的顺序
            Dictionary<int, int> numdic = new Dictionary<int, int>();

            //将数组转换为键值对
            for (int i = 0; i < nums.Length; i++)
            {
                int dif = target - nums[i];
                if (numdic.ContainsKey(dif))
                {
                    return new[] { i, numdic[dif] };
                }
                numdic[nums[i]] = i;
            }

            return new int[] { };
        }


       




        public static void Run()
        {
            TwoSum3(new[] { 2, 7, 11, 15 }, 9);
        }
    }
}