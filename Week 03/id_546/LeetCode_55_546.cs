using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Medium
{
    /// <summary>
    /// 55. 跳跃游戏
    /// </summary>
    public class JumpGame
    {
        public bool CanJump(int[] nums)
        {
            int curMax = nums[0];
            for (int i = 1; i < nums.Length; i++)
            {
                if (curMax < i) return false; 
                curMax = Math.Max(curMax, i + nums[i]);
            }
            return true;
        }
    }
}
