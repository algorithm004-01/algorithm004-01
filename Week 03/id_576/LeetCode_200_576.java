import java.util.concurrent.CountDownLatch;

import sun.security.x509.IssuerAlternativeNameExtension;

/**
 * LeetCode_200_576
 */
public class LeetCode_200_576 {

    int dx[] = {-1, 1, 0, 0};
    int dy[] = {0, 0, -1, 1};
    char[][] g;
    
    //1. DFS: floodfill ,找到一个岛，把附近都炸为0这种思路一定要学起来
    public int numIslands(char[][] grid) {
        int islands = 0;
        g = grid;
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[i].length; j++) {
                if (g[i][j] == '0') continue;
                // g[i][j] = 1 为陆地
                islands += sink(i, j);
            }
        return islands;
        }    
    }    

    int sink(int i, int j) {
        //terminator
        if (g[i][j] = '0')
            return 0;

        // i,j == '1'
        g[i][j] = '0';

        for (int k = 0; k < dx.length; k++) {
            int x = i + dx[k], y = j + dy[k];
            if (x > 0 && x < g.length && y > 0 && y < 
            g[i].length) {
                if (g[x][y] == '0') continue;
                sink(x, y);
            }
        }
        return 1;
    }

}