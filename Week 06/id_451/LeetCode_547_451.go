func findCircleNum(grid [][]int) int {
    ruf := make(map[string]*UnionFind)
	for i, _ := range grid {
		kv := fmt.Sprintf(`%v`, i)
		uf := NewUnionFind(kv)
		ruf[kv] = uf
	}
	for i, row := range grid {
		for j, v := range row {
			if v == 1 || v == '1' {
				kva := fmt.Sprintf(`%v`, i)
				uf := ruf[kva]
				kvb := fmt.Sprintf(`%v`, j)
				puf := ruf[kvb]
				uf.Union(puf)

			}
		}
	}
	count := make(map[string]struct{})
	for _, uf := range ruf {
		kv := uf.Find().v.(string)
		count[kv] = struct{}{}
	}
	return len(count)
} 

type UnionFind struct {
	v      interface{}
	parent *UnionFind
}

func NewUnionFind(v interface{}) *UnionFind {
	uf := new(UnionFind)
	uf.v = v
	uf.parent = uf
	return uf
}

func (uf *UnionFind) Find() *UnionFind {
	t := uf
	for {
		if t.parent == t {
			return t
		}
		t = t.parent
	}
}
func (a *UnionFind) Union(b *UnionFind) {
	pa := a.Find()
	pb := b.Find()
	pb.parent = pa
}

