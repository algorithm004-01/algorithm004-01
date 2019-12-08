// DFS:


var levelOrder = function(root) {
  let visited = new Set();
  let ans = [];

  function DFS(node, visited, level) {
    if (visited.has(node) || node === null) {
      return;
    }
    if (ans[level] === undefined) {
      ans[level] = [];
    }
    ans[level].push(node.val);
    visited.add(node);
    DFS(node.left, visited, level + 1);

    DFS(node.right, visited, level + 1);
  }
  DFS(root, visited, 0);
  return ans;
};
