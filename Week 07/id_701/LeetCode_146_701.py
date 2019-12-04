from collections import OrderedDict


class LRUCache:
    def __init__(self, capacity: int):
        self.dic = OrderedDict()
        self.capacity = capacity

    def get(self, key: int) -> int:
        if key not in self.dic:
            return -1
        val = self.dic.pop(key)
        self.dic[key] = val
        return val

    def put(self, key: int, value: int) -> None:
        if key in self.dic:
            self.dic.pop(key)
        else:
            if self.capacity > 0:
                self.capacity -= 1
            else:
                self.dic.popitem(last=False)
        self.dic[key] = value
