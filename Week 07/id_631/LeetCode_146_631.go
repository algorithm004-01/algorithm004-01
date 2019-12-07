type Node struct {
	Key      int
	Val      int
	Prev     *Node
	Next     *Node
}

//97.58% 58.89%
type LRUCache struct {
    Capacity int
	Cache map[int]*Node
	Head *Node
	Tail *Node
}

func Constructor(capacity int) LRUCache {
    return LRUCache{
		Capacity: capacity,
		Cache: make(map[int]*Node),
	}
}

func (this *LRUCache) Get(key int) int {
	node, ok := this.Cache[key]
	if !ok {
		return -1
	}

	if this.Tail == node { 
		return node.Val
	} else if this.Head == node { 
		this.Head = node.Next
	} else {
		node.Prev.Next = node.Next
		node.Next.Prev = node.Prev
	}

	// 把node放到最后
	node.Prev = this.Tail
	node.Next = nil
	this.Tail.Next = node
	this.Tail = node
	return node.Val
}


func (this *LRUCache) Put(key int, value int)  {
	if this.Capacity <= 0 {
		return
	}

	// Get方法回自动把存在的值移动到最后
	if this.Get(key) != -1 {
		this.Tail.Val = value
		return
	}

	node := &Node{Key: key, Val: value}
	this.Cache[key] = node
	if this.Head == nil {
		this.Head = node
		this.Tail = node
		return
	}

	node.Prev = this.Tail
	this.Tail.Next = node
	this.Tail = node

    /*为了减少重复代码 先执行map赋值了 所以这里要 - 1*/
	if len(this.Cache) - 1 == this.Capacity {
		delete(this.Cache, this.Head.Key)
		this.Head = this.Head.Next
	}
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * obj := Constructor(capacity);
 * param_1 := obj.Get(key);
 * obj.Put(key,value);
 */