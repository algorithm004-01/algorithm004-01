# 【446-Week 06】学习总结 字典树

> Trie 树的本质，就是利用字符串之间的公共前缀，将重复的前缀合并在一起。

## Trie树操作

* 将字符串集合构造成Trie树--一个将字符串插入到Trie树的过程

* 在Trie树中查询一个字符串

  ***


## 存储Trie树

* 借助散列表思想存储

  假设我们的字符串中只有从 a 到 z 这 26 个小写字母，我们在数组中下标为 0 的位置，存储指向子节点 a 的指针，下标为 1 的位置存储指向子节点 b 的指针，以此类推，下标为 25 的位置，存储的是指向的子节点 z 的指针。如果某个字符的子节点不存在，我们就在对应的下标的位置存储 null。

  ```java
  public class Trie {
    private TrieNode root = new TrieNode('/'); // 存储无意义字符
  
    // 往Trie树中插入一个字符串
    public void insert(char[] text) {
      TrieNode p = root;
      for (int i = 0; i < text.length; ++i) {
        int index = text[i] - 'a';
        if (p.children[index] == null) {
          TrieNode newNode = new TrieNode(text[i]);
          p.children[index] = newNode;
        }
        p = p.children[index];
      }
      p.isEndingChar = true;
    }
  
    // 在Trie树中查找一个字符串
    public boolean find(char[] pattern) {
      TrieNode p = root;
      for (int i = 0; i < pattern.length; ++i) {
        int index = pattern[i] - 'a';
        if (p.children[index] == null) {
          return false; // 不存在pattern
        }
        p = p.children[index];
      }
      if (p.isEndingChar == false) return false; // 不能完全匹配，只是前缀
      else return true; // 找到pattern
    }
  
    public class TrieNode {
      public char data;
      public TrieNode[] children = new TrieNode[26];
      public boolean isEndingChar = false;
      public TrieNode(char data) {
        this.data = data;
      }
    }
  }
  ```

  

* 耗内存，空间换时间
* 尽管比较耗费内存，但是对内存不敏感或者内存消耗在接受范围内的情况下，在 Trie 树中做字符串匹配还是非常高效的，时间复杂度是 O(k)，k 表示要匹配的字符串的长度。

## Trie树适用场景

* 散列表或者红黑树适合：动态集合数据的查找。
* Trie 树适合：查找前缀匹配的字符串