#
# @lc app=leetcode.cn id=146 lang=python3
#
# [146] LRU缓存机制
#

# @lc code=start
class Double_LL_Node:
    def __init__(self, val):
        self.val = val
        self.prev = None
        self.next = None

class LRUCache:

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.curr_length = 0
        self.hashmap = {}
        
        self.head = Double_LL_Node(0)
        self.tail = Double_LL_Node(0)
        
        self.head.next = self.tail
        self.tail.prev = self.head       
    
    def move_to_front_in_LL(self, node):
        temp = self.head.next
        
        self.head.next = node
        node.prev = self.head
        
        node.next = temp
        temp.prev = node
    
    def remove_from_LL(self, node):
        temp_next = node.next
        temp_before = node.prev
        
        temp_before.next = temp_next
        temp_next.prev = temp_before
        
        return node
        
    def get(self, key: int) -> int:
        if key in self.hashmap:
            node = self.remove_from_LL(self.hashmap[key][1])
            self.move_to_front_in_LL(node)
            return self.hashmap[key][0] 
        else:
            return -1

    def put(self, key: int, value: int) -> None:
        if key in self.hashmap:
            node = self.remove_from_LL(self.hashmap[key][1])
            self.move_to_front_in_LL(node)
            
            self.hashmap[key][0] = value
        
        else:
            if self.curr_length<self.capacity:
                new_node = Double_LL_Node(key)
                
                self.hashmap[key] = [value, new_node]
                
                self.move_to_front_in_LL(new_node)
                
                self.curr_length +=1
                
            else:
                last_node = self.tail.prev
                old_key = last_node.val
                self.remove_from_LL(last_node)
                self.hashmap.pop(old_key)
                
                self.curr_length -= 1
                self.put(key, value)


# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)
# @lc code=end

