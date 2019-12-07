# NOTE
## trie 字典树

> Trie 树只是不适合精确匹配查找，这种问题更适合用散列表或者红黑树来解决。Trie 树比较适合的是查找前缀匹配的字符串

  ```py
  class Trie(object): 
    def __init__(self):
      self.root = {}
      self.end_of_word  ="#"
      def insert(self,word):
        node = self.root
        for char in word:
          node = node.setdefault(char,{})  # node = {}
        node[self.end_of_word] = self.end_of_end #{'#':'#'}
      
      def search(self,word):
        node = self.root
        for char in word:
          if char not in node:
            return False
          node = node[char]
        return self.end_of_word in node
  
      def startsWith(self,prefix):
        node = self.root
        for char in prefix:
          if char not in node:
            return False
          node = node[char]
        return True
  ```

## 并查集

makeset(s):建立一个新的并查集，其中包含s个单元素集合

unionSet(x,y) x y 所在的集合合并，x、y所在的集合不能相交

find(x) 找打x所在的集合的代表，改操作用于判断两个元素是否位于同一个集合

```py
def int(p):
  p = [for i in range(n)]

def union(self,p,i,j):
  p1 = self.parent(p,i)
  p2 = self.parent(p,j)
  p[p1] = p2

def parent(self,p,i):
  root = i
  while p[root] !=root:
    root = p[root]

  while p[i] !=i:
    x=i
    i=p[i]
    p[x] = root

```

