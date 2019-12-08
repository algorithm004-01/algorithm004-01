class Solution {
    /**
     *  使用深度优先搜索，类似岛屿个数的题目
     * @param M
     * @return
     */
    public int findCircleNum(int[][] M) {
        // 二维数组长度，即所有人的个数
        int length = M.length;
        // 统计朋友圈个数
        int count = 0;
        // 访问标志
        boolean[] flag = new boolean[length];
        for (int i = 0; i <length; i++) {
            //对每个人 如果未被访问，深度优先搜索访问，朋友圈个数 +1
            if (flag[i] == false) {
                DFS(i,M,flag);
                count++;
            }
        }
        return count;
    }

    /**
     * 深度优先搜索
     * @param i
     * @param M
     * @param flag
     */
    public void DFS(int i,int[][] M,boolean[] flag) {
        flag[i] = true;
        for (int j = 0; j < M[i].length; j++) {
            if (flag[j] == false && M[i][j] == 1) {
                DFS(j,M,flag);
            }
        }
    }
}