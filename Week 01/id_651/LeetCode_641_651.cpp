/*
    思路
    1. 循环数组。 通过移动索引的方式处理。 
        新增头，则赋值给头索引位置的值，索引相应的减1并跑多一圈，对结果求余，得到新头索引
        新增尾，则复制给尾索引位置的值，索引相应的加1,对结果求余,得到新尾索引
        删除头，(将头指针指向下一个)头索引相应的加1，对结果求余，得到新头索引
        删除尾，(将尾指针指向上一个)尾索引相应的减1，并跑多一圈，对结果求余，得到新为尾索引。
    结论：
        相对于思路1, 思路2的代码更简单清晰, 可以少很多的判断条件。 
        1. 指针的初始值也很重要
        2. 与环形链表的题类似， 在那个基础上加了增删查的操作
*/
# include <iostream>
# include <windows.h>
# include <vector>
using namespace std;

class MyCircularDeque {
    private:
    vector<int> buffer;
    int count;
    int msize;
    int first;
    int last;
public:
    MyCircularDeque(int k) {
      // 初始化值
      buffer.assign(k, 0);
      msize = k, count = 0, last = 0, first = msize - 1;
    }
    
    bool insertFront(int value) {
        if (count == msize) return false;
        buffer[first] = value;
        first = (first - 1 + msize) % msize;
        ++count;
        return true;
    }
    
    bool insertLast(int value) {
        if (count == msize) return false;
        buffer[last] = value;
        last = (last + 1) % msize;
        ++count;
        return true;
    }
    
    bool deleteFront() {
        if (isEmpty()) return false;
        first = (first + 1) % msize;
        --count;
        return true;
    }
    
    bool deleteLast() {
        if (isEmpty()) return false;
        last = (last - 1 + msize) % msize;
        --count;
        return true;
    }
    
    int getFront() {
        return isEmpty() ? -1 : buffer[(first + 1) % msize];
    }
    
    int getRear() {
        return isEmpty() ? -1 : buffer[(last - 1 + msize) % msize];
    }
    
    bool isEmpty() {
        return count == 0;
    }
    
    bool isFull() {
        return count == msize;
    }
};


int main(){
    MyCircularDeque mq(3);
    return 0;
}