// leetcode : https://leetcode-cn.com/problems/friend-circles/

type FriendCircle struct {
    parents []int
    count int
}

func NewFriendCircle(n int) FriendCircle {
    f := FriendCircle{ parents: make([]int, n) }
    f.count = n
    for i, _ := range f.parents {
        f.parents[i] = i
    }
    return f
}

func (f *FriendCircle)parent(i int) int {
    for f.parents[i] != i {
        f.parents[i] = f.parents[f.parents[i]]
        i = f.parents[i]
    }
    return i
}

func (f *FriendCircle)union(i, j int) {
    pi, pj := f.parent(i), f.parent(j)
    if pi == pj {
        return
    }
    f.parents[pi] = pj
    f.count--
}
func findCircleNum(M [][]int) int {
    f := NewFriendCircle(len(M))
    for i := 0; i < len(M); i++ {
        for j := i+1; j < len(M[i]); j++ {
            if M[i][j] == 1 {
                f.union(i, j)
            }
        }
    }
    return f.count
}