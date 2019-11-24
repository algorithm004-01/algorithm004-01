/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-11-19 18:58
 **/

/**
 * 仿解:并查集
 * link:https://leetcode-cn.com/problems/surrounded-regions/solution/bfsdi-gui-dfsfei-di-gui-dfsbing-cha-ji-by-ac_pipe/
 */
public class Leetcode_130_371 {
    class UnionFind {
        int[] parents;

        /**
         * 给所有节点设置标识(父节点的值)
         *
         * @param totalNodes
         */
        public UnionFind(int totalNodes) {
            parents = new int[totalNodes];
            for (int i = 0; i < totalNodes; i++) {
                parents[i] = i;
            }
        }

        /**
         * 合并两个节点
         *
         * @param node1
         * @param node2
         */
        void union(int node1, int node2) {
            int root1 = find(node1);
            int root2 = find(node2);
            if (root1 == root2) return;
            parents[root2] = root1;
        }

        /**
         * 查找根节点
         *
         * @param node
         * @return
         */
        int find(int node) {
            while (parents[node] != node) {//路径压缩,如果当前节点不是根节点,下一次直接查看爷爷结点是不是根节点
                parents[node] = parents[parents[node]];
                node = parents[node];
            }
            return node;
        }

        boolean isConnected(int node1, int node2) {
            return find(node1) == find(node2);
        }
    }

    public void solve(char[][] board) {
        int rows = board.length;
        //1.边界判断
        if (board == null || rows == 0) return;
        int cols = board[0].length;
        //2.初始化:初始化所有节点, 即父节点的值是自身==>即当前节点就是根节点(parents[i]=i)
        UnionFind uf = new UnionFind(rows * cols + 1);
        int dummyNode = rows * cols;//该节点是一个虚拟结点,board中不存在

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    int currIndex = nodeIndex(i, j, cols);
                    //3.遇到边界上的O的结点,和dummyNode结点进行合并,形成一个连通区
                    if (i == 0 || i == rows - 1 || j == 0 || j == cols - 1) {
                        uf.union(currIndex, dummyNode);
                    } else {
                        //4.和上下左右存在的'0'结点合并成一个联通区
                        if (i > 0 && board[i - 1][j] == 'O') {
                            uf.union(currIndex, nodeIndex(i - 1, j, cols));
                        }
                        if (i < rows - 1 && board[i + 1][j] == 'O') {
                            uf.union(currIndex, nodeIndex(i + 1, j, cols));
                        }
                        if (j > 0 && board[i][j - 1] == 'O') {
                            uf.union(currIndex, nodeIndex(i, j - 1, cols));
                        }
                        if (j < cols -1 && board[i][j + 1] == 'O') {
                            uf.union(currIndex, nodeIndex(i, j + 1, cols));
                        }
                    }

                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (uf.isConnected(nodeIndex(i, j, cols), dummyNode)) {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }


    }

    /**
     * 将二维的坐标转化成一维的唯一标识
     */
    int nodeIndex(int i, int j, int cols) {
        return i * cols + j;
    }

}
