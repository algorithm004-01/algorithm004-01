package week06

type UnionFind struct {
	count int
	parent []int
}

func (this *UnionFind) UnionFind(n int) {
	this.count = n
	for i := 0; i < n; i++ {
		this.parent = append(this.parent, i)
	}
}

func (this *UnionFind) find (p int) int {
	for p != this.parent[p] {
		this.parent[p] = this.parent[this.parent[p]]
		p = this.parent[p]
	}
	return p
}

func (this *UnionFind) union(p, q int){
	rootp := this.find(p)
	rootq := this.find(q)
	if rootp != rootq {
		this.parent[rootp] = rootq
		this.count--
	}
}
