import java.util.*;
/**
 * LRU缓存机制
 */
class Solution {
    static class LRUCache {

        private HashMap<Integer, Node> map;
        private int size = 0;
        private int capacity;
        private Node head;
        private Node tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.map = new HashMap<>();
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                node.prev.next = node.next;
                node.next.prev = node.prev;
                Node next = this.head.next;
                this.head.next = node;
                node.prev = this.head;
                node.next = next;
                next.prev = node;
                return node.value;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (map.containsKey(key))
                map.get(key).value = value;
            if (get(key) == -1) {
                Node newNode = new Node();
                newNode.key = key;
                newNode.value = value;
                Node next = this.head.next;
                this.head.next = newNode;
                newNode.prev = this.head;
                newNode.next = next;
                next.prev = newNode;
                map.put(key, newNode);
                this.size++;
                if (this.size > this.capacity) {
                    Node last = this.tail.prev;
                    last.prev.next = this.tail;
                    this.tail.prev = last.prev;
                    map.remove(last.key);
                }
            }
        }

        static class Node {
            private int key;
            private int value;
            private Node prev;
            private Node next;
        }
    }

    /**
     * LRU缓存机制
     * 调用类库
     */
    static class LRUCache2 extends LinkedHashMap<Integer, Integer> {

        private int capacity;

        public LRUCache2(int capacity) {
            super(capacity, 0.75f, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        //默认返回 false，代表不进行最老值的删除，所以需要重写
        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
    }
}