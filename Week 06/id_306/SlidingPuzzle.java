package sf.week6;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Created by LynnSun on 2019/11/24.
 * 力扣题目地址：https://leetcode-cn.com/problems/sliding-puzzle
 * A *  LeetCode国际站大佬的题解
 */
public class SlidingPuzzle {
    /*思路：基于普通的广度优先遍历解法, 将普通队列改为使用优先队列,
    每次队列poll时都先通过compareTo选择一个"曼哈顿距离最短",
    也就是距离最终结果需要交换次数最小的一个分支进行计算。
    像这样每次队列都择优poll, BFS算法就能够更快速的到达终点。

    关于曼哈顿距离：二维坐标中, 一个点(x1, y1)到另一个点(x2, y2)的曼哈顿距离 = |x1 - x2| + |y1 - y2|

    由于优先队列默认队列头元素是最小元素，故我们可以拿来作为小根堆使用,
    故这个A* 算法的主要思想就是每次都poll一个交换次数 + 曼哈顿距离最短的节点, 从而达到枝减的效果*/

    public int slidingPuzzle(int[][] board) {
        //find index of zero in board
        int[] index = findIndexOfZero(board);
        if (index == null || index.length == 0) return -1;
        //create start State
        State start = new State(board, 0, index[0], index[1]);
        //PQ
        PriorityQueue<State> pq = new PriorityQueue<>();
        pq.add(start);
        //Set
        Set<State> visited = new HashSet<>();
        visited.add(start);
        //moves
        int[][] moves = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!pq.isEmpty()) {
            State currState = pq.poll();//poll State by priority
            if (currState.isGoal()) return currState.taken;
            for (int[] move : moves) {
                int x = currState.zeroSetX + move[0];
                int y = currState.zeroSetY + move[1];
                if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) continue;
                State newState = currState.swap(x, y);
                if (newState != null && visited.add(newState)) pq.offer(newState);
            }
        }
        return -1;
    }

    class State implements Comparable<State>{
        int[][] stateBoard;
        int taken;
        int zeroSetX;
        int zeroSetY;

        public State(int[][] stateBoard, int taken, int zeroSetX, int zeroSetY) {
            //这里新建数组的原因是：直接赋地址的话, 若通过当前State的stateBoard创建了一个NewState, 修改NewState.stateBoard的同时也会修改this.stateBoard
            this.stateBoard = new int[2][3];
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 3; j++) {
                    this.stateBoard[i][j] = stateBoard[i][j];
                }
            }
            this.taken = taken;
            this.zeroSetX = zeroSetX;
            this.zeroSetY = zeroSetY;
        }

        /**
         * swap board where x = zeroX, y = zeroY
         *
         * @param   x
         * @param   y
         * @return  State
         */
        public State swap(int x, int y) {
            State res = new State(stateBoard, taken + 1, x, y);
            int temp = res.stateBoard[x][y];
            res.stateBoard[x][y] = res.stateBoard[zeroSetX][zeroSetY];
            res.stateBoard[zeroSetX][zeroSetY] = temp;
            return res;
        }

        /**
         * priority distance
         * @return
         */
        public int distance() {
            int result = 0;
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 3; j++) {
                    if (stateBoard[i][j] == 0) continue;
                    //二维坐标曼哈顿距离计算：res = |x - i| + |y - j|
                    int val = stateBoard[i][j] - 1;
                    int x = val/3;
                    int y = val%3;
                    result += Math.abs(x - i) + Math.abs(y - j);
                }
            }
            return result;
        }

        public boolean isGoal() {
            return distance() == 0;
        }

        /**
         * compare all states in PQ while poll or remove
         * @param that
         * @return
         */
        @Override
        public int compareTo(State that) {
            return this.distance() + this.taken - that.distance() - that.taken;
        }

        @Override
        public boolean equals(Object obj) {
            return Arrays.deepEquals(((State) obj).stateBoard, this.stateBoard);
        }

        @Override
        public int hashCode() {
            return Arrays.deepHashCode(stateBoard);
        }
    }

    private int[] findIndexOfZero(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) return new int[]{i, j};
            }
        }
        return null;
    }
}
