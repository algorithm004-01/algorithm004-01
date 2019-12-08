class LRUCache {
public:
    LRUCache(int capacity) {
        capacity_ = capacity;
    }
    
    int get(int key) {
        auto it = map_.find(key);
        if(map_.end() == it)
        return -1;

        pair<int, int> kv = *map_[key];
        list_.erase(map_[key]);
        list_.push_front(kv);
        map_[key] = list_.begin();
        return kv.second;
    }
    
    void put(int key, int value) {
        auto it = map_.find(key);
        if(it == map_.end()){
            if(list_.size() == capacity_){
                auto last = list_.back();
                map_.erase(last.first);
                list_.pop_back();
            }

            list_.push_front(make_pair(key,value));
            map_[key] = list_.begin();
        } else {
            list_.erase(map_[key]);
            list_.push_front(make_pair(key,value));
            map_[key] = list_.begin();
        }
        
    }

private:
    int capacity_;
    list<pair<int, int>> list_;
    map<int, list<pair<int, int>>::iterator> map_;
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */