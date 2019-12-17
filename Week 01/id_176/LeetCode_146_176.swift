/*
 * @lc app=leetcode.cn id=146 lang=swift
 *
 * [146] LRU缓存机制
 *
 * https://leetcode-cn.com/problems/lru-cache/description/
 *
 * algorithms
 * Medium (43.82%)
 * Likes:    271
 * Dislikes: 0
 * Total Accepted:    20.6K
 * Total Submissions: 47K
 * Testcase Example:  '["LRUCache","put","put","get","put","get","put","get","get","get"]\n' +
  '[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]'
 *
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * 
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) -
 * 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 * 
 * 进阶:
 * 
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * 
 * 示例:
 * 
 * LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
 * 
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // 返回  1
 * cache.put(3, 3);    // 该操作会使得密钥 2 作废
 * cache.get(2);       // 返回 -1 (未找到)
 * cache.put(4, 4);    // 该操作会使得密钥 1 作废
 * cache.get(1);       // 返回 -1 (未找到)
 * cache.get(3);       // 返回  3
 * cache.get(4);       // 返回  4
 * 
 * 
 */

// @lc code=start

class LRUCache {

    class DoublyLinkedList {
        
        class LinkedListNode {
            let key: Int
            var value: Int
            var next: LinkedListNode?
            weak var previous: LinkedListNode?
            
            init(key: Int = 0, value: Int = 0) {
                self.key = key
                self.value = value
            }
        }
        
        let head = LinkedListNode()
        let tail = LinkedListNode()
        var size = 0
        
        init() {
            head.next = tail
            tail.previous = head
        }
        
        func addNode(_ node: LinkedListNode) {
            
            node.previous = head
            node.next = head.next
            
            head.next?.previous = node
            head.next = node
            
            size += 1
        }
        
        func removeNode(_ node: LinkedListNode) {
            
            node.next?.previous = node.previous
            node.previous?.next = node.next
            
            size -= 1
        }
        
        func moveNodeToHead(_ node: LinkedListNode) {
            
            removeNode(node)
            addNode(node)
        }
        
        func popTail() -> LinkedListNode? {
            
            guard size > 0, let node = tail.previous else {
                return nil
            }
            removeNode(node)
            return node
        }
    }
    
    
    let capacity: Int
    let list = DoublyLinkedList()
    var cache = [Int: DoublyLinkedList.LinkedListNode]()
    
    init(_ capacity: Int) {
        self.capacity = capacity
    }
    
    func get(_ key: Int) -> Int {
        
        guard let node = cache[key] else {
            return -1
        }
        
        list.moveNodeToHead(node)
        return node.value
    }
    
    func put(_ key: Int, _ value: Int) {
        
        if let node = cache[key] {
            node.value = value
            list.moveNodeToHead(node)
        } else {
            
            let node = DoublyLinkedList.LinkedListNode(key: key, value: value)
            list.addNode(node)
            cache[key] = node
            
            if list.size > capacity, let tail = list.popTail() {
                cache[tail.key] = nil
            }
        }
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * let obj = LRUCache(capacity)
 * let ret_1: Int = obj.get(key)
 * obj.put(key, value)
 */
// @lc code=end

