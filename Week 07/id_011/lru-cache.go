package algorithm00401

type LRUCache struct {
	len, cap    int
	first, last *doubleLinkedList
	nodes       map[int]*doubleLinkedList
}

type doubleLinkedList struct {
	key, val   int
	prev, next *doubleLinkedList
}

func Constructor(capacity int) LRUCache {
	return LRUCache{
		cap:   capacity,
		nodes: make(map[int]*doubleLinkedList, capacity),
	}
}

func (this *LRUCache) Get(key int) int {
	if node, ok := this.nodes[key]; ok {
		this.moveToFirst(node)
		return node.val
	}
	return -1
}

func (this *LRUCache) moveToFirst(node *doubleLinkedList) {
	if this.first == node {
		return
	} else if this.last == node {
		this.removeLast()
	} else {
		node.prev.next = node.next
		node.next.prev = node.prev
	}
	this.addToFirst(node)
}

func (this *LRUCache) removeLast() {
	if this.last.prev != nil {
		this.last.prev.next = nil
	} else {
		this.first = nil
	}
	this.last = this.last.prev
}

func (this *LRUCache) addToFirst(node *doubleLinkedList) {
	if this.last == nil {
		this.last = node
	} else {
		this.first.prev = node
		node.next = this.first
	}
	this.first = node
}

func (this *LRUCache) Put(key int, value int) {
	if node, ok := this.nodes[key]; ok {
		node.val = value
		this.moveToFirst(node)
	} else {
		if this.len == this.cap {
			delete(this.nodes, this.last.key)
			this.removeLast()
		} else {
			this.len++
		}
		node := &doubleLinkedList{
			key: key,
			val: value,
		}
		this.nodes[key] = node
		this.addToFirst(node)
	}
}
