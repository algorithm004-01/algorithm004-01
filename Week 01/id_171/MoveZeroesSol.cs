namespace Poplar.Algorithm.WeekOne
{
    /// <summary>
    /// 移动零
    /// https://leetcode.com/problems/move-zeroes/
    /// https://leetcode-cn.com/problems/move-zeroes/
    /// </summary>
    public class MoveZeroesSol
    {
        public void MoveZeroes(int[] nums)
        {
            if (nums == null || nums.Length < 2)
            {
                return;
            }
            int j = 0;
            for (int i = 0; i < nums.Length; i++)
            {
                if (nums[i] != 0)
                {
                    nums[j] = nums[i];
                    if (i != j)
                    {
                        nums[i] = 0;
                    }
                    j++;
                }
            }
        }
    }
}
