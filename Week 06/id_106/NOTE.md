# 20191118-1124 学习总结

本周主要学习了 字典树 并查集 剪枝 双向BFS 启发式搜索 AVL 红黑树

其中字典树的特点是使用空间换时间，对于单词的搜索有天然的便利
一般的单词搜索字典树由每层26个子去实现，分别代表26个字母，搜索一个单词搜索的深度即为单子字母个数

并查集是一种特殊的数据结构，适用于集合的合并，关系查找。
每个节点有一个parent，当parent为自己时即为当前集合的代表元素。
集合的合并也即为将parent指向另一个节点即可完成
并查集的代码模板
```java
class UnionFind { 
	private int count = 0; 
	private int[] parent; 
	public UnionFind(int n) { 
		count = n; 
		parent = new int[n]; 
		for (int i = 0; i < n; i++) { 
			parent[i] = i;
		}
	} 
	public int find(int p) { 
		while (p != parent[p]) { 
			parent[p] = parent[parent[p]]; 
			p = parent[p]; 
		}
		return p; 
	}
	public void union(int p, int q) { 
		int rootP = find(p); 
		int rootQ = find(q); 
		if (rootP == rootQ) return; 
		parent[rootP] = rootQ; 
		count--;
	}
}
```

剪枝是指在树遍历时如果能提前判断较优的路径，可以将次优的路径“剪掉”，减少遍历的步骤
典型的题目是八皇后 数独

双向BFS是指从树的两端进行BFS，当元素碰撞的时候即得到结果

启发式搜索是在BFS的基础上使用优先级队列，根据不同的题目定义函数，来减少遍历的步骤

