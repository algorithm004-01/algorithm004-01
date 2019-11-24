package com.hjj.leetcode.week6.nov24;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LeetCode773 {
    public int slidingPuzzle(int[][] board) {
        int R = board.length, C = board[0].length;
        int sr = 0, sc = 0;

        //Find sr, sc
        search:
        for (sr = 0; sr < R; sr++)
            for (sc = 0; sc < C; sc++)
                if (board[sr][sc] == 0)
                    break search;

        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        PriorityQueue<Node> heap = new PriorityQueue<Node>((a, b) ->
                (a.heuristic + a.depth) - (b.heuristic + b.depth));
        Node start = new Node(board, sr, sc, 0);
        heap.add(start);

        Map<String, Integer> cost = new HashMap();
        cost.put(start.boardstring, 9999999);

        String target = Arrays.deepToString(new int[][]{{1, 2, 3}, {4, 5, 0}});
        String targetWrong = Arrays.deepToString(new int[][]{{1, 2, 3}, {5, 4, 0}});

        while (!heap.isEmpty()) {
            Node node = heap.poll();
            if (node.boardstring.equals(target))
                return node.depth;
            if (node.boardstring.equals(targetWrong))
                return -1;
            if (node.depth + node.heuristic > cost.get(node.boardstring))
                continue;

            for (int[] di : directions) {
                int nei_r = di[0] + node.zero_r;
                int nei_c = di[1] + node.zero_c;

                // If the neighbor is not on the board or wraps incorrectly around rows/cols
                if ((Math.abs(nei_r - node.zero_r) + Math.abs(nei_c - node.zero_c) != 1) ||
                        nei_r < 0 || nei_r >= R || nei_c < 0 || nei_c >= C)
                    continue;

                int[][] newboard = new int[R][C];
                int t = 0;
                for (int[] row : node.board)
                    newboard[t++] = row.clone();

                // Swap the elements on the new board
                newboard[node.zero_r][node.zero_c] = newboard[nei_r][nei_c];
                newboard[nei_r][nei_c] = 0;

                Node nei = new Node(newboard, nei_r, nei_c, node.depth + 1);
                if (nei.depth + nei.heuristic >= cost.getOrDefault(nei.boardstring, 9999999))
                    continue;
                heap.add(nei);
                cost.put(nei.boardstring, nei.depth + nei.heuristic);
            }
        }

        return -1;
    }
}

class Node {
    int[][] board;
    String boardstring;
    int heuristic;
    int zero_r;
    int zero_c;
    int depth;

    Node(int[][] B, int zr, int zc, int d) {
        board = B;
        boardstring = Arrays.deepToString(board);

        //Calculate heuristic
        heuristic = 0;
        int R = B.length, C = B[0].length;
        for (int r = 0; r < R; ++r)
            for (int c = 0; c < C; ++c) {
                if (board[r][c] == 0) continue;
                int v = (board[r][c] + R * C - 1) % (R * C);
                // v/C, v%C: where board[r][c] should go in a solved puzzle
                heuristic += Math.abs(r - v / C) + Math.abs(c - v % C);
            }
        heuristic /= 2;
        zero_r = zr;
        zero_c = zc;
        depth = d;
    }
}

