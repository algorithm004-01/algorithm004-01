import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-11-02 11:59
 **/

public class Leetcode_874_371 {
    public static void main(String[] args) {
        int[] commands = {-2, -1, 8, 9, 6};
//        int[] commands = {4, -1, 3};
//        int[] commands = {4, -1, 4, -2, 4};
//        int[][] obstacles = {{2, 4}};
        int[][] obstacles = {{-1, 3}, {0, 1}, {-1, 5}, {-2, -4}, {5, 4}, {-2, -3}, {5, -1}, {1, -1}, {5, 5}, {5, 2}};
        int res = robotSim2(commands, obstacles);
        System.out.println("res = " + res);
    }

    /**
     * 防解1:模拟法
     *
     * @author Shaobo.Qian
     * @date 2019/11/3
     * @link https://leetcode.com/problems/walking-robot-simulation/discuss/152322/Maximum!-This-is-crazy!
     */
    public static int robotSim2(int[] commands, int[][] obstacles) {
        //1.存入所有障碍物坐标
        Set<String> set = new HashSet<>();
        for (int[] obstacle : obstacles) {
            set.add(obstacle[0] + "," + obstacle[1]);
        }

        //2.模拟在坐标系四个方向上(上,右,下,左)
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        //dir对应 二维数组dirs的索引,(现实含义:将要在某个方向前进一步)
        int dir = 0, x = 0, y = 0, result = 0;
        for (int c : commands) {
            if (c == -1) {
                dir++;
                if (dir == 4) {//转换后,才能在 dirs 中取到值
                    dir = 0;
                }
            } else if (c == -2) {
                dir--;
                if (dir == -1) {//转换后,才能在 dirs 中取到值
                    dir = 3;
                }
            } else {
                while (c-- > 0 && !set.contains((x + dirs[dir][0]) + "," + (y + dirs[dir][1]))) {
                    x += dirs[dir][0];
                    y += dirs[dir][1];
                }
            }
            result = Math.max(result, x * x + y * y);
        }
        return result;
    }

    /**
     * 原解1:模拟(未解出)
     *
     * @author Shaobo.Qian
     * @date 2019/11/2
     */
    public static int robotSim1(int[] commands, int[][] obstacles) {

        //定义横坐标 x,纵坐标 y,找到 x,y 的最大距离
        int x = 0, y = 0;
        //y轴上的障碍物
        List<Integer> yList = new ArrayList<>();
        //x轴上的障碍物
        List<Integer> xList = new ArrayList<>();
        //2.根据障碍物,真实在 x,y 上的最大距离
        if (obstacles != null && obstacles.length > 0) {
            for (int i = 0; i < obstacles.length; i++) {
                //判断是否能遇到障碍物
                xList.add(obstacles[i][0]);
                yList.add(obstacles[i][1]);
            }
        }

        boolean xFlag = true;
        //1.假设没有障碍物的情况下x,y 的最大距离
        for (int i = 0; i < commands.length; i++) {
            if (xFlag) {
                x += commands[i];
            } else {
                y += commands[i];
            }
            if (commands[i] == -1 && yList.contains(y)) {
                //在x轴上前进,判断是否会遇见障碍物
                //看当前的y是否在ySet中
                for (int j = 0; j < xList.size(); j++) {
                    Integer lowLimit = xList.get(j);
                    if (x >= xList.get(j)) {
                        xList.remove(lowLimit);
                        j--;
                    } else {
                        x = Math.min(x += commands[i], lowLimit - 1);
                    }
                }
            } else if (commands[i] == -2 && xList.contains(x)) {
                //在y 轴上前进,判断是否会遇见障碍物
                for (int j = 0; j < yList.size(); j++) {
                    Integer lowLimit = yList.get(j);
                    if (y >= yList.get(j)) {
                        yList.remove(lowLimit);
                        j--;
                    } else {
                        y = Math.min(y += commands[i], lowLimit - 1);
                    }
                }
                xFlag = false;
            } else {
                if (xFlag) {
                    x += commands[i];
                } else {
                    y += commands[i];
                }
            }
        }
        return x * x + y * y;
    }
}
