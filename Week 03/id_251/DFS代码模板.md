## 递归写法

### 树、图
```python
visited = set()

def dfs(node, visited):
    if node in visited: # terminator
        # already visited
        return
    
    visited.add(node)

    # process current node here.
    ...
    for next_node in node.children():
        if not next_node in visited:
            dfs(next_node, visited)
```

### 二叉树
```python
visited = set()

def dfs(node):
    # terminator
    if node in visited:
        # already visited
        return
    
    visited.add(node)

    # process current node
    # ... # logic here
    dfs(node.left)
    dfs(node.right)
```

## 非递归写法
```python
def DFS(tree):
    # terminator
    if tree.root is None:
        return []
    
    visited, stack = set(), [tree.root]
    
    while stack:
        node = stack.pop()
        visited.add(node)
        
        process(node)
        nodes = generate_related_nodes(node)
        stack.push(nodes)
    
    # other processing work
    ...
```