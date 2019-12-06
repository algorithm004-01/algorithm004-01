# NOTE

## 搜索

- 所有节点都访问一次
- 所有节点仅访问一次

### DFS

```js
// recursion
function dfs(node, visited) {
  if (node in visited) {
    return;
  }
  visited.push(node);
  for (let next_node of node.children()) {
    if (!(node in visited)) {
      dfs(next_node, visited);
    }
  }
}
// iteration
function dfs(node) {
  let stack = [];
  if (!node) return stack;
  stack.push(node);
  let visited = [];
  while (stack.length !== 0) {
    let n = stack.pop();
    visited.push(n);
    for (let next_node of node.children()) {
      if (!(next_node in visited)) {
        stack.push(next_node);
      }
    }
  }
}
```

### BFS

```js
function bfs(node) {
  let queue = [];
  queue.push(node);
  let visited = [];
  while (queue.length !== 0) {
    let n = queue.shift();
    visited.push(n);
    for (let next_node of node.children()) {
      queue.push(next_node);
    }
  }
}
```

## 二分搜索

1. 目标函数单调
2. 存在上下界
3. 可以通过索引访问

```js
let left = 0,
  right = array.length - 1;
while (left <= right) {
  let mid = (left + right) >>> 1;
  if (array[mid] === target) {
    return mid;
  } else if (array[mid] <= target) {
    left = mid + 1;
  } else {
    right = mid - 1;
  }
}
```
