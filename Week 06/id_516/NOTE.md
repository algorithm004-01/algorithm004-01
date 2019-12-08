# 字典树

> 单词查找树，Trie树。典型应用用于统计、排序和保存大量的字符串，经常呗搜索引擎系统应用于文本词频统计。优点：利用字符串的公共前缀来减少查询的时间，减少无所谓的字符串比较，查询效率比哈希树高。

```java
class TrieNode {
    public boolean isWord;
    public TrieNode[] children = new TrieNode[26];
    public TrieNode() {}
}

class Trie {
    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode ws = root;
        for (int i = 0; i <  word.length(); i++) {
            char c = word.charAt(i);
            if (ws.children[c - 'a'] == null) {
                ws.children[c - 'a'] = new TrieNode();
            }
            ws = ws.children[c - 'a'];
        }
        ws.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode ws = root;
        for (int i = 0; i < word.length(); i ++) {
            char c = word.charAt(i);
            if (ws.children[c - 'a'] == null) return false;
            ws = ws.children[c -'a'];
        }
        return ws.isWord;
    }


    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode ws = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (ws.children[c - 'a'] == null) return false;
            ws = ws.children[c - 'a']
        }
        return true;
    }
}
```

### 题目

- https://leetcode-cn.com/problems/implement-trie-prefix-tree/#/description
- https://leetcode-cn.com/problems/word-search-ii/





# 并查集

> 是一种树形的数据结构，用于处理一些不相交集合的合并及查询问题。



### 题目

- https://leetcode-cn.com/problems/friend-circles/
- https://leetcode-cn.com/problems/number-of-islands/
- https://leetcode-cn.com/problems/surrounded-regions/

# 高级搜索

优化： 不重复，剪枝(生成括号问题)

搜索方向：DFS、BFS、双向搜索、启发式搜索



## 剪枝

> 深度优先搜索中让搜索树减少一些节点，使得搜索时间减少的功能。





### 题目

- https://leetcode-cn.com/problems/n-queens/
- https://leetcode-cn.com/problems/valid-sudoku/description/
- https://leetcode-cn.com/problems/sudoku-solver/#/description





## 双向BFS

> 双向BFS适用于知道起点和终点的状态下使用，从起点和终点两个方向开始进行搜索，可以非常大的提高单个BFS的搜索效率。



```python
def BFS(graph,start,end):
  start_queue = []
  end_queue = []
  start_queue.append([start])
  end_queue.append([end])
  
  while start_queue:
    node = start_queue.pop()
    visited.add(node)
    
    process(node)
    
    nodes = generate_related_nodes(node)
    queue.push(nodes)
    
    if (len(start_queue) > len(end_queue)):
      start_queue,end_queue = end_queue,start_queue
      
    ...
  
```



### 题目

- https://leetcode-cn.com/problems/word-ladder/
- https://leetcode-cn.com/problems/minimum-genetic-mutation/



## 启发式搜索

> 依赖于估价函数与优先级队列。
>
> 启发式搜索(Heuristically Search)又称为有信息搜索(Informed Search)，它是利用问题拥有的启发信息来引导搜索，达到减少搜索范围、降低问题复杂度的目的，这种利用启发信息的搜索过程称为启发式搜索。





### 题目



- https://leetcode-cn.com/problems/shortest-path-in-binary-matrix/
- https://leetcode-cn.com/problems/sliding-puzzle/
- https://leetcode-cn.com/problems/sudoku-solver/





## 平衡树

> 它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。实现有红黑树、AVL....