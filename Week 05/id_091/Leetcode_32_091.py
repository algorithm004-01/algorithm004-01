import collections


class LRUCache:

    def __init__(self, capacity):
        self.dic = collections.OrderedDict()
        self.remain = capacity

    def get(self, key):
        if key not in self.dic:
            return -1
        v = self.dic.pop(key)
        self.dic[key] = v
        return v

    def put(self, key, value):
        if key in self.dic:
            self.dic.pop(key)
        else:
            if self.remain > 0:
                self.remain -= 1
            else:
                self.dic.popitem(last=False)
        self.dic[key] = value


if __name__ == '__main__':
    capacity = ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
    obj = LRUCache(capacity)
    obj.put('test', 'test')
    param_1 = obj.get('test')
    print(param_1)
