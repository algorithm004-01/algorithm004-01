# NOTE
一、并查集
1. 情景
组团、配对问题

（微信朋友圈好友）

2. 基本操作
makeSet(s):建立一个新的并查集，其中包含s个单元素集合

unionSet(x,y):把元素x和元素y所在的集合合并，要求x和y所在的集合不相交，如果相交不合并

find(x)：找到元素x所在的集合的代表，该操作也可以用于判断两个元素是否位于同一个集合，只要将他们各自的代表比较以下就可以了



二、高级搜索
1.剪枝
状态树是树和分支的形态

2.回溯
回溯法采用试错的思想，它尝试分步的去解决一个问题。在分步解决问题的过程中，当它尝试发现现有的分步答案不能得到有效的正确的解答的时候，它将取消上一步甚至是几步的计算，再通过其它可能的分步解答再次寻找问题的答案。

回溯法通常采用最简单的递归方法来实现，在反复重复上述的步骤后可能出现两种情况：

找到一个可能存在的正确的答案
在尝试了所有可能的分步方法后宣告该问题没有答案
在最坏的情况下，回溯法会导致一次复杂度为指数级时间的计算。

3.双向BFS
和单向BFS异曲同工
用set来表示

4.启发式搜索
根据某一项条件，优化搜索方向
通过优先级

三、平衡二叉树
AVL树
红黑树
B树
23树
1.AVL树
为什么需要出现AVL树：极端情况下，树变成链表，查询效率变成logn
平衡二叉树

Balance Factor(平衡因子）任何结点它左子树的高度减去它的右子树的高度（有时相反）：{0,1-1}
通过旋转操作
左旋
右旋
左右旋
右左旋
不足：
结点需要存储额外信息，且调整频次频繁

2.红黑树
近似平衡二叉树(Binary Search Tree)，它能够确保任何一个结点的左右子树的高度小于两倍。具体来说，红黑树是满足于如下条件的二叉搜索树

每个结点要么是红色，要么是黑色
根结点是黑色
每个结点(NIL结点，空结点）是黑色
不能有相邻接的两个红色结点
从任一结点到其每个叶子结点的所有路径都包含相同数目的黑色结点
时间复杂度logn，调整时间相对比较小


Trie模版

```javascript
var Trie = function() {
  this.isWord = false;
  this.next = {};
};

/**
 * Inserts a word into the trie.
 * @param {string} word
 * @return {void}
 */
Trie.prototype.insert = function(word) {
  let cur = this;
  for (let i = 0; i < word.length; i++) {
    if (!cur.next[word[i]]) {
      cur.next[word[i]] = new Trie();
    }
    cur = cur.next[word[i]];
  }
  cur.isWord = true;
};

/**
 * Returns if the word is in the trie.
 * @param {string} word
 * @return {boolean}
 */
Trie.prototype.search = function(word) {
  let cur = this;
  for (let i = 0; i < word.length; i++) {
    if (!cur.next.hasOwnProperty(word[i])) {
      return false;
    }
    cur = cur.next[word[i]];
  }
  return cur.isWord;
};

/**
 * Returns if there is any word in the trie that starts with the given prefix.
 * @param {string} prefix
 * @return {boolean}
 */
Trie.prototype.startsWith = function(prefix) {
  let cur = this;
  for (let i = 0; i < prefix.length; i++) {
    if (!cur.next.hasOwnProperty(prefix[i])) {
      return false;
    }
    cur = cur.next[prefix[i]];
  }
  return true;
};

```

并查集示例
```javascript
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
```