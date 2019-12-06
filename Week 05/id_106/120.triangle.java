/*
 * @lc app=leetcode id=120 lang=java
 *
 * [120] Triangle
 *
 * https://leetcode.com/problems/triangle/description/
 *
 * algorithms
 * Medium (41.04%)
 * Likes:    1399
 * Dislikes: 164
 * Total Accepted:    207.7K
 * Total Submissions: 502.9K
 * Testcase Example:  '[[2],[3,4],[6,5,7],[4,1,8,3]]'
 *
 * Given a triangle, find the minimum path sum from top to bottom. Each step
 * you may move to adjacent numbers on the row below.
 * 
 * For example, given the following triangle
 * 
 * 
 * [
 * ⁠    [2],
 * ⁠   [3,4],
 * ⁠  [6,5,7],
 * ⁠ [4,1,8,3]
 * ]
 * 
 * 
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * 
 * Note:
 * 
 * Bonus point if you are able to do this using only O(n) extra space, where n
 * is the total number of rows in the triangle.
 * 
 */

// @lc code=start
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] f = new int[triangle.size()+1];
        for(int i = triangle.size()-1; i >= 0; i--){
            for(int j = 0; j < triangle.get(i).size(); j++){
                f[j] = Math.min(f[j] , f[j+1]) + triangle.get(i).get(j);
            }
        }
        return f[0];
    }
}
// @lc code=end
/**
 * 子问题：每一个节点向下的路径只能有两条，将三角形看作二维数组,每个节点表示为 a[i][j] 路径表示为f[i][j]
 * 则每个下一层子路径可以表示为 f[i+1][j] f[i+1][j+1]
 * 最短路径的总和就可以表示为 f[i][j] = min(f[i+1][j] , f[i+1][j+1]) + a[i][j]
 * 
 *   j
 *i [2],
 *  [3,4],
 *  [6,5,7],
 *  [4,1,8,3]
 * 
 * 注意从下往上进行遍历，如果从上往下遍历j+1很难取
 */

