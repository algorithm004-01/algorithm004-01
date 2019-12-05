class MyCircularDeque {
public:
    MyCircularDeque(int k) { 
        start = 0, end = 1, cap = k; 
    }
    
    bool insertFront(int value) {
        if(mp.size() == cap) return false;
        mp[start--] = value;
        return true;
    }
    
    bool insertLast(int value) {
        if(mp.size() == cap) return false;
        mp[end++] = value;
        return true;
    }
    
    bool deleteFront() {
        if(!mp.size()) return false;
        mp.erase(++start);
        return true;
    }
    
    bool deleteLast() {
        if(!mp.size()) return false;
        mp.erase(--end);
        return true;
    }
    
    int getFront() {
        if(!mp.size()) return -1;
        return mp[start + 1];
    }
    
    int getRear() {
        if(!mp.size()) return -1;
        return mp[end - 1];
    }
    
    bool isEmpty() { return !mp.size(); }
    
    bool isFull() { return mp.size() == cap; }
private:
    unordered_map<int, int> mp;
    int start, end, cap;    
};

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque* obj = new MyCircularDeque(k);
 * bool param_1 = obj->insertFront(value);
 * bool param_2 = obj->insertLast(value);
 * bool param_3 = obj->deleteFront();
 * bool param_4 = obj->deleteLast();
 * int param_5 = obj->getFront();
 * int param_6 = obj->getRear();
 * bool param_7 = obj->isEmpty();
 * bool param_8 = obj->isFull();
 */
