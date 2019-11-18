/**
 * LeetCode_120_576
 */
public class LeetCode_120_576 {
    // 1. brute-force, 递归，n层，o(2^n)
    public int minimumTotal1(List<List<Integer>> triangle) {
        
    }

    /**
     * 2. DP
     * a.重复性（分治）
     * b.定义状态数组
     * c.dp方程
     */ 
    public int minimumTotal1(List<List<Integer>> triangle) {
        int[] A = new int[triangle.size()+1];
        for (int i = triangle.size()-1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                A[j] = Math.min(A[j], A[j+1]) + triangle.get(i).get(j);
            }
        }
        return A[0];
    }
}