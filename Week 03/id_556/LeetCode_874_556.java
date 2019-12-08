class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        // clockwise: up, right, down, left
        int[][] offset = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = 0, y = 0;
        int max = 0;
        // index of the offset towards dir
        int dir = 0;
        Set<String> obs = new HashSet<>();
        for (int i = 0; i < obstacles.length; ++i) {
            obs.add(obstacles[i][0] + "," + obstacles[i][1]);
        }
        // let's move
        for (int i = 0; i < commands.length; ++i) {
            if (commands[i] == -1) {
                //  turn right
                dir = (dir + 1) % 4;
            } else if (commands[i] == -2) {
                // turn left
                dir = (dir + 3) % 4;
            } else if (commands[i] > 0) {
                for (int j = 0; j < commands[i]; ++j) {
                    int nextX = x + offset[dir][0];
                    int nextY = y + offset[dir][1];
                    if (obs.contains(nextX + "," + nextY)) {
                        // stop and stay
                        break;
                    } else {
                        x = nextX;
                        y = nextY;
                        max = Math.max(max, x * x + y * y);
                    }
                }
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
