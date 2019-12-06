
type Node struct {
	k, v int
}
type LRUCache struct {
	l   *list.List
	m   map[int]*list.Element
	len int
}

func Constructor(capacity int) LRUCache {
	return LRUCache{
		l:   list.New(),
		len: capacity,
		m:   make(map[int]*list.Element),
	}
}

func (lru *LRUCache) Get(key int) int {
	ptr, ok := lru.m[key]
	if !ok {
		return -1
	}
	lru.l.MoveToFront(ptr)
	return ptr.Value.(Node).v
}

func (lru *LRUCache) Put(key int, value int) {

	ptr, ok := lru.m[key]
	if ok {
		lru.l.Remove(ptr)
	}
	e := lru.l.PushFront(Node{key, value})
	lru.m[key] = e
	if lru.l.Len() > lru.len {
		e = lru.l.Back()
		delete(lru.m, e.Value.(Node).k)
		lru.l.Remove(e)
		return
	}
}

