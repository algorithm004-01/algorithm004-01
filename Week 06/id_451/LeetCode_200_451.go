package main

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

func numIslands(grid [][]byte) int {
	ruf := make(map[string]*UnionFind)
	for i, row := range grid {
		for j, v := range row {
			if v == 1 || v == '1' {

				kv := fmt.Sprintf(`%v:%v`, i, j)
				uf := NewUnionFind(kv)
				ruf[kv] = uf
			}
		}
	}
	for i, row := range grid {
		for j, v := range row {
			if v == 1 || v == '1' {
				kv := fmt.Sprintf(`%v:%v`, i, j)
				uf := ruf[kv]
				if i-1 >= 0 && grid[i-1][j] == '1' {
					kv := fmt.Sprintf(`%v:%v`, i-1, j)
					puf := ruf[kv]

					uf.Union(puf)
				}
				if j-1 >= 0 && grid[i][j-1] == '1' {
					kv := fmt.Sprintf(`%v:%v`, i, j-1)
					puf := ruf[kv]
					uf.Union(puf)
				}
				if i+1 < len(grid) && grid[i+1][j] == '1' {
					kv := fmt.Sprintf(`%v:%v`, i+1, j)
					puf := ruf[kv]
					uf.Union(puf)
				}
				if j+1 < len(row) && grid[i][j+1] == '1' {
					kv := fmt.Sprintf(`%v:%v`, i, j+1)
					puf := ruf[kv]
					uf.Union(puf)
				}
			}
		}
	}
	count := make(map[string]struct{})
	for _, uf := range ruf {
		kv := uf.Find().v.(string)
		// fmt.Println(kv)
		count[kv] = struct{}{}
	}
	return len(count)
}
