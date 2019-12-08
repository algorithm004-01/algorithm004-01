package vip.ruoyun.week3.lesson10;

import java.util.HashSet;
import java.util.Set;

/**
 * 机器人在一个无限大小的网格上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令：
 * <p>
 * -2：向左转 90 度
 * -1：向右转 90 度
 * 1 <= x <= 9：向前移动 x 个单位长度
 * 在网格上有一些格子被视为障碍物。
 * <p>
 * 第 i 个障碍物位于网格点  (obstacles[i][0], obstacles[i][1])
 * <p>
 * 如果机器人试图走到障碍物上方，那么它将停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。
 * <p>
 * 返回从原点到机器人的最大欧式距离的平方。
 * <p>
 * 链接：https://leetcode-cn.com/problems/walking-robot-simulation
 */
public class LeetCode_874_641 {

    public static int robotSim(int[] commands, int[][] obstacles) {
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = 0, y = 0;
        int dir_index = 0;
        int ans = 0;
        Set<String> blockSet = new HashSet<>();
        for (int i = 0; i < obstacles.length; i++) {
            blockSet.add(obstacles[i][0] + "," + obstacles[i][1]);
        }

        for (int i = 0; i < commands.length; i++) {
            if (commands[i] == -1) {
                dir_index = (dir_index + 1) % 4;
            } else if (commands[i] == -2) {
                dir_index = (dir_index + 3) % 4;
            } else if (commands[i] > 0) {
                for (int j = 1; j <= commands[i]; j++) {
                    int next_x = x + dir[dir_index][0];
                    int next_y = y + dir[dir_index][1];
                    if (blockSet.contains(next_x + "," + next_y)) {
                        break;
                    } else {
                        x = next_x;
                        y = next_y;
                        ans = Math.max(ans, x * x + y * y);
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(robotSim(new int[]{4, -1, 3}, new int[][]{}));
    }
}
