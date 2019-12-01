import java.util.Arrays;

/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-11-19 15:39
 **/

public class Leetcode_547_371 {

    /**
     * 查找元素 i 的根节点
     * @param i
     * @param parent 所有元素的父节点
     * @return
     */
    public int find(int i, int[] parent) {
        if (parent[i] == -1) return i;
        return find(parent[i], parent);
    }

    public void union(int i, int j, int[] parent) {
        int iRoot = find(i, parent);
        int jRoot = find(j, parent);
        if(iRoot == jRoot) return;
        parent[iRoot] = jRoot;
    }

    /**
     * 仿解1:并查集
     * @param M
     * @return
     * @link https://leetcode-cn.com/problems/friend-circles/solution/peng-you-quan-by-leetcode/
     */
    public int findCircleNum(int[][] M) {
        int len = M.length;
        int[] parent = new int[len];
        Arrays.fill(parent, -1);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (M[i][j] == 1 && i != j) { //i == j就是自己
                    union(i, j, parent);
                }
            }
        }

        int count = 0;
        for (int i = 0; i < len; i++) {
            if(parent[i] == -1) count++;
        }
        return count;
    }

}
