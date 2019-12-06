using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Easy
{
    /// <summary>
    /// 874. 模拟行走机器人
    /// </summary>
    public class WalkingRobotSimulation
    {
        public int RobotSim(int[] commands, int[][] obstacles)
        {
            List<string> list = new List<string>();
            foreach (int[] obs in obstacles)
            {
                list.Add(obs[0] + " " + obs[1]);
            }
            int[][] dirs = new int[][] { 
                new []{ 0, 1 }, 
                new []{ 1, 0 }, 
                new []{ 0, -1 }, 
                new []{ -1, 0 } 
                };

            int d = 0, x = 0, y = 0, result = 0;

            for(int w=0;w<commands.Length;w++)
            {
                if (commands[w] == -1)
                {
                    d++;
                    if (d == 4)
                    {
                        d = 0;
                    }
                }
                else if (commands[w] == -2)
                {
                    d--;
                    if (d == -1)
                    {
                        d = 3;
                    }
                }
                else
                {
                    while (commands[w]-- > 0 && !list.Contains((x + dirs[d][0]) + " " + (y + dirs[d][1])))
                    {
                        x += dirs[d][0];
                        y += dirs[d][1];
                    }
                }
                result = Math.Max(result, x * x + y * y);
            }
            return result;
        }
    }
}
