package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 潘磊明
 * @date 2019/11/4
 */
public class WalkingRobotSimulation {
    public int robotSim(int[] commands, int[][] obstacles) {
        int direction = 0; //机器人前行的方向 0-right, 1-down, 2-left, 3-up
        Set<String> obstaclesSet = obstracles2Set(obstacles);
        int i = 0, j = 0;
        int distance = 0;
        int max = 0;
        for (int x = 0; x < commands.length; x++) {
            if (isDirection(commands[x])) direction = getDirection(commands[x], direction);
            else {
                if (direction == 0) j = moveRight(obstaclesSet, i, j, commands[x]);
                else if (direction == 1) i = moveDown(obstaclesSet, i, j, commands[x]);
                else if (direction == 2) j = moveLeft(obstaclesSet, i, j, commands[x]);
                else i = moveUp(obstaclesSet, i, j, commands[x]);
                max = Math.max(max, i * i + j * j);
            }
        }
        return max;
    }

    private Set<String> obstracles2Set(int[][] obstacles){
        Set<String> set = new HashSet<>();
        for (int i = 0; i < obstacles.length; i++) {
            set.add(obstacles[i][0] + "@" + obstacles[i][1]);
        }
        return set;
    }

    private boolean isDirection(int value){
        return value < 0;
    }

    /**
     * 获取当前机器人行走的方向
     * @param direct
     * @return
     */
    private int getDirection(int direct, int direction){
        if (direct == -1) direction++;
        else if (direct == -2) direction--;
        if (direction > 3) return direction - 4;
        else if (direction < 0) return direction + 4;
        else return direction;
    }

    private int moveRight(Set<String> set, int i, int j, int distance) {
        for (int x = 1; x < distance + 1; x++) {
            if (set.contains(i + "@" + (j + x))) {
                return x + j - 1;
            }
        }
        return j + distance;
    }

    private int moveLeft(Set<String> set, int i, int j, int distance) {
        for (int x = 1; x < distance + 1; x++) {
            if (set.contains(i + "@" + (j - x))) {
                return j - x + 1;
            }
        }
        return j - distance;
    }

    private int moveUp(Set<String> set, int i, int j, int distance) {
        for (int x = 1; x < distance + 1; x++) {
            if (set.contains((i - x) + "@" + j)) {
                return i - x + 1;
            }
        }
        return i - distance;
    }

    private int moveDown(Set<String> set, int i, int j, int distance) {
        for (int x = 1; x < distance + 1; x++) {
            if (set.contains((i + x) + "@" + j)) {
                return i + x - 1;
            }
        }
        return i + distance;
    }

    public static void main(String[] args) {
        WalkingRobotSimulation w = new WalkingRobotSimulation();
        int[] commands = new int[]{4, -1, 4, -2, 4};
        int[][] obstacles = new int[][]{
                new int[]{2,4}
        };
        w.robotSim(commands, obstacles);
    }
}
