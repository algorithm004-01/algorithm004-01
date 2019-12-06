"""
运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
进阶:
你是否可以在 O(1) 时间复杂度内完成这两种操作？
"""
class ListNode:
	def __init__(self, key=None, value=None):
		self.key = key
		self.value = value
		self.prev = None
		self.next = None

class LRUCache:
	def __init__(self, capacity):
		self.capcaity = capacity
		self.hashmap = {}
		self.head = ListNode()
		self.tail = ListNode()
		self.head.next = self.tail
		self.tail.prev = self.head

	def move_node_to_tail(self, key):
		node = self.hashmap[key]
		node.prev.next = node.next
		node.next.prev = node.prev
		node.prev = self.tail.prev
		node.next = self.tail
		self.tail.prev.next = node
		self.tail.prev = node

	def get(self, key):
		if key in self.hashmap:
			self.move_node_to_tail(key)
		res = self.hashmap.get(key, -1)
		if res == -1:
			return res
		else:
			return res.value

	def put(self, key, value):
		if key in self.hashmap:
			self.hashmap[key].value = value
			self.move_node_totail(key)
		else:
			if len(self.hashmap)  == self.capacity:
				self.hashmap.pop(self.head.next.key)
				self.head.next = self.head.next.next
				self.head.next.prev = self.head
			new = ListNode(key, value)
			self.hashmap[key] = new
			new.prev = self.tail.prev
			new.next = self.tail
			self.tail.prev.next = new
			self.tail.prev = new


if __name__ = '__main__':
	pass