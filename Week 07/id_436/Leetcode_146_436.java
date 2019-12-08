class LRUCache {
    int capacity;
    Map<Integer, Integer> map;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new LinkedHashMap<Integer, Integer>();
    }
    
    public int get(int key) {
        if (map.get(key) == null) {
            return -1;
        }
        int val = map.remove(key);
        map.put(key, val);
        return val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);
            map.put(key, value);
            return;
        }
        if (map.size() >= capacity){
            int head = map.keySet().iterator().next();
            map.remove(head);
        }
        map.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
