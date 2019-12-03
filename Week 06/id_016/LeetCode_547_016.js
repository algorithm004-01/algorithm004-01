/*
 * @lc app=leetcode id=547 lang=javascript
 *
 * [547] Friend Circles
 *
 * https://leetcode.com/problems/friend-circles/description/
 *
 * algorithms
 * Medium (55.38%)
 * Likes:    1330
 * Dislikes: 105
 * Total Accepted:    117.3K
 * Total Submissions: 209.8K
 * Testcase Example:  '[[1,1,0],[1,1,0],[0,0,1]]'
 *
 * 
 * There are N students in a class. Some of them are friends, while some are
 * not. Their friendship is transitive in nature. For example, if A is a direct
 * friend of B, and B is a direct friend of C, then A is an indirect friend of
 * C. And we defined a friend circle is a group of students who are direct or
 * indirect friends.
 * 
 * 
 * 
 * Given a N*N matrix M representing the friend relationship between students
 * in the class. If M[i][j] = 1, then the ith and jth students are direct
 * friends with each other, otherwise not. And you have to output the total
 * number of friend circles among all the students.
 * 
 * 
 * Example 1:
 * 
 * Input: 
 * [[1,1,0],
 * ⁠[1,1,0],
 * ⁠[0,0,1]]
 * Output: 2
 * Explanation:The 0th and 1st students are direct friends, so they are in a
 * friend circle. The 2nd student himself is in a friend circle. So return
 * 2.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: 
 * [[1,1,0],
 * ⁠[1,1,1],
 * ⁠[0,1,1]]
 * Output: 1
 * Explanation:The 0th and 1st students are direct friends, the 1st and 2nd
 * students are direct friends, so the 0th and 2nd students are indirect
 * friends. All of them are in the same friend circle, so return 1.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * N is in range [1,200].
 * M[i][i] = 1 for all students.
 * If M[i][j] = 1, then M[j][i] = 1.
 * 
 * 
 */

// @lc code=start
/**
 * @param {number[][]} M
 * @return {number}
 本质上是使用数组存储当前的所有值和引用
 */
var findCircleNum = function(M) {
  let count = M.length;
  let n = M.length;
  let p = [];

  // 初始化数组
  let init = n => {
    for (let i = 0; i < n; i++) {
      p[i] = i;
    }
  };

  // 查找某个父节点
  let find = index => {
    while (index !== p[index]) {
      p[index] = p[p[index]];
      index = p[index];
    }
    return index;
  };

  // 合并并查集
  let union = (index1, index2) => {
    let root1 = find(index1);
    let root2 = find(index2);
    if (root1 === root2) return;
    p[root1] = root2;
    count--;
  };

  // 初始化并查集
  init(n);

  // 遍历二维数组,合并关联集
  for (let i = 0; i < n; i++) {
    for (let j = 0; j < n; j++) {
      if (M[i][j] === 1) {
        union(i, j);
      }
    }
  }

  return count;
};
// @lc code=end

console.log(
  findCircleNum([
    [1, 1, 0],
    [1, 1, 1],
    [0, 1, 1]
  ])
);