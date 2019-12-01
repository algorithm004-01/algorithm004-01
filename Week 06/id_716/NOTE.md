# NOTE

## 笔记

### 字典树 Trie

Trie 是一种专门处理字符串匹配的数据结构，用来解决在一组字符串集合中快速查找某个字符串的问题。

题目和作业

- Tire 树代码模板
- <https://leetcode-cn.com/problems/implement-trie-prefix-tree/#/description> (done)
- <https://leetcode-cn.com/problems/word-search-ii/> (done)
- 分析单词搜索 2 用 Tire 树方式实现的时间复杂度，请同学们提交在第 6 周的学习总结中。

### 并查集 Disjoint Set

将 n 个不同的元素分成一组不相交的集合，同时需要两种特别的操作：寻找包含指定元素的唯一集合和合并两个集合。并查集就是这样一种数据结构，基本操作如下：

1. makeSet(s): 建立一个新的并查集，其中包含s个单元素集合
2. unionSet(s1,s2): 把元素x和元素y所在的集合合并，要求x和y所在的集合不合并，如果相交则不合并
3. find(x): 找到x所在集合的代表，该操作也用来判断两个元素是否位于同一集合，只要比较他们各自的代表

题目：

- <https://leetcode-cn.com/problems/friend-circles>  (done)
- <https://leetcode-cn.com/problems/number-of-islands/> (done)
- <https://leetcode-cn.com/problems/surrounded-regions/> (done)

### 高级搜索算法

高级搜索由初级搜索演化而来，最容易想到的是暴力搜索，也是最简单的，所谓暴力就是穷举所有可能；在此基础之上，在特定的子问题上做优化，比如对重复子问题记忆化、对不满足的情况提前剪枝；此外，在不同方向上的搜索策略，又可以抽象为深度优先和广度优先，这两种算法都可以做到将所有节点都搜索完毕。以上这些都可以总结为基本的搜索算法，是比较不智能的；那么更加聪明的搜索是在子问题的选择上做优化，更加符合解的趋势。

- 剪枝
- 双向 BFS
- A* 启发式搜索

题目：

- <https://leetcode-cn.com/problems/climbing-stairs/>  (done)
- <https://leetcode-cn.com/problems/generate-parentheses/>  (done)
- <https://leetcode-cn.com/problems/n-queens>
- <https://leetcode-cn.com/problems/valid-sudoku/description/>  (done)
- <https://leetcode-cn.com/problems/sudoku-solver/#/description>
- <https://leetcode-cn.com/problems/word-ladder/>
- <https://leetcode-cn.com/problems/minimum-genetic-mutation/>
- <https://leetcode-cn.com/problems/shortest-path-in-binary-matrix/>
- <https://leetcode-cn.com/problems/sliding-puzzle/>

## 总结

本周是第六周了，悄悄的接近了尾声。本周重点围绕字典树、并查集、剪枝搜索、双向BFS和启发式搜索等进行了学习，每部分都有了不同的收获。

### 字典树

又叫 `Trie`，是一种树形结构。同时它还是一种专门用来处理字符串匹配的数据结构，在一组字符串集合中快速查找某个字符串。比较典型的应用是搜索引擎的搜索关键词提示。通过观察 Trie，我们能理解它的本质是利用字符串之间的公共前缀，将重复的前缀合并在一起。

学习 Trie，重点需要掌握以下几点：

- 如何存储 Trie？

Trie 的实现是将字符串进行分割，分成可识别的字符，将这些字符构造成一个树形结构，所以我们需要首先限定字符范围，我们暂时只考虑26个英文字母，如果考虑中文字符等，范围就更加广了。

```java
// 典型的 Trie 树的节点的框架
class TrieNode {
    char data;
    TrieNode[] links = new TrieNode[26];
}
```

说明 Trie 的每个节点都包含 26 个 TrieNode.

- Trie 的常见操作

Trie 需要做的主要操作有两个：根据关键词库构建一个 Trie和从给定的 Trie 中查找一个字符串

```java
public void insert(char[] text);
// or
public void insert(String word);

public boolean search(String word);
// or
public boolean startsWith(String word);
```

我们需要根据关键词的词库动态构建一颗 Trie 树，构建的时间复杂度是 O(n), n 是所有关键词的长度和。
对于查找操作，时间复杂度是 O(k), k 是要查找单词的长度。

在构建 Trie 时，我们使用了一个数组来表示一个节点，这样会有点浪费内存，但是查询效率会很高，一种空间换时间的思路。但是我们可以对 Trie 的节点做优化，比如使用有序数组、跳表、散列表、红黑树等，以提高内存使用。

- Trie 的特点与限制

1. 字符串包含的字符集不能太大，否则内存占用会迅速膨胀。
2. 要求字符串的前缀重合比较多，不然空间消耗会变大很多。
3. 要实现一个 Trie，需要满足工程化的要求，不是一件容易的事情。
4. Trie 是用指针的方式将数据串联起来的，对缓存不友好（因为数据存取是按页的）

Trie 树不适合精确匹配查找，这种问题更适合用散列表或者红黑树来解决。Trie 树比较适合的是查找前缀匹配的字符串，比如关键词提示。

### 并查集

Disjoint Set，将 n 个不同的元素分成一组不相交的集合，同时需要两种特别的操作：寻找包含指定元素的唯一集合和合并两个集合。并查集就是这样一种数据结构，基本操作如下：

1. makeSet(s): 建立一个新的并查集，其中包含s个单元素集合
2. unionSet(s1,s2): 把元素x和元素y所在的集合合并，要求x和y所在的集合不合并，如果相交则不合并
3. find(x): 找到x所在集合的代表，该操作也用来判断两个元素是否位于同一集合，只要比较他们各自的代表

非常典型的题目是：朋友圈个数、岛屿数量以及被围绕的区域等。

### 高级搜索

高级搜索由初级搜索演化而来，最容易想到的是暴力搜索，也是最简单的，所谓暴力就是穷举所有可能；在此基础之上，在特定的子问题上做优化，比如对重复子问题记忆化、对不满足的情况提前剪枝；此外，在不同方向上的搜索策略，又可以抽象为深度优先和广度优先，这两种算法都可以做到将所有节点都搜索完毕。以上这些都可以总结为基本的搜索算法，是比较不智能的；那么更加聪明的搜索是在子问题的选择上做优化，更加符合解的趋势。

对于图和图相关的算法会再做个更加深入的总结，以及实现一些比较常用的功能。
