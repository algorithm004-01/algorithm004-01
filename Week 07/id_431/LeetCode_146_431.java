package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 使用双向链表和hashMap实现或者直接使用LinkedHashMap
 * @author 潘磊明
 * @date 2019/12/5
 */
public class LRUCache {
    DoubleNode<Integer> head;
    DoubleNode<Integer> tail;
    int size;
    int capacity;
    Map<Integer, DoubleNode<Integer>> map;

    public LRUCache(int capacity) {
        this.head = new DoubleNode<>(Integer.MAX_VALUE, Integer.MAX_VALUE);
        this.tail = new DoubleNode<>(Integer.MAX_VALUE, Integer.MAX_VALUE);
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.size = 0;
        this.capacity = capacity;
        map = new HashMap<>();
    }

    /**
     * 缓存的数据是否超出最大数量
     * @return
     */
    private boolean isFull() {
        return this.size > this.capacity;
    }

    /**
     * 删除节点
     * @param doubleNode
     */
    private void removeNode(DoubleNode<Integer> doubleNode) {
        DoubleNode<Integer> prev = doubleNode.prev;
        DoubleNode<Integer> next = doubleNode.next;
        prev.next = next;
        next.prev = prev;
    }

    /**
     * 添加节点
     * @param doubleNode
     */
    private void addNode(DoubleNode<Integer> doubleNode) {
        DoubleNode<Integer> tmp = head.next;
        head.next = doubleNode;
        doubleNode.next = tmp;
        doubleNode.prev = head;
        tmp.prev = doubleNode;
    }

    /**
     * 将节点移动到头部
     * @param doubleNode
     */
    private void moveNodeToHead(DoubleNode<Integer> doubleNode) {
        removeNode(doubleNode);
        addNode(doubleNode);
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        DoubleNode<Integer> tmp = map.get(key);
        moveNodeToHead(tmp);
        return tmp.value;
    }

    public void put(int key, int value) {
        //先判断是否已经存在
        if (map.containsKey(key)) {
            DoubleNode<Integer> tmp = map.get(key);
            tmp.value = value;
            moveNodeToHead(tmp);
        }else {
            DoubleNode<Integer> doubleNode = new DoubleNode<>(key, value);
            map.put(key, doubleNode);
            addNode(doubleNode);
            size++;
            if (isFull()) {
                map.remove(tail.prev.key);
                removeNode(tail.prev);
                size--;
            };
        }
    }

    class DoubleNode<T> {
        DoubleNode prev;
        DoubleNode next;
        T value;
        T key;

        DoubleNode(T key, T value){
            this.value = value;
            this.key = key;
        }
    }
}
