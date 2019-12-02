import java.util.HashMap;

/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-11-27 08:07
 **/

public class Leetcode_146_371 {


    /**
     * 仿解:(双向链表+hashmap)
     *
     * @author Shaobo.Qian
     * @date 2019/11/28
     * @link https://leetcode-cn.com/problems/lru-cache/solution/lru-ce-lue-xiang-jie-he-shi-xian-by-labuladong/
     */
    class Node {
        int key, value;
        Node next, prev;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class DoubleList {
        private Node head, tail;//头尾虚节点,方便指针操作
        private int size;

        public DoubleList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        /**
         * 在链表头部添加节点
         *
         * @param x
         */
        public void addFirst(Node x) {
            x.next = head.next;
            x.prev = head;
            head.next.prev = x;
            head.next = x;
            size++;
        }

        /**
         * 删除某个节点(调用方需保证 Node x 存在)
         *
         * @param x
         */
        public void remove(Node x) {
            x.prev.next = x.next;
            x.next.prev = x.prev;
            size--;
        }

        /**
         * 删除并返回最后一个节点
         *
         * @return
         */
        public Node removeLast() {
            if (tail.prev == head) return null; //没有节点
            Node last = tail.prev;
            remove(last);
            return last;
        }

        /**
         * 返回链表中节点的个数
         *
         * @return
         */
        public int size() {
            return size;
        }
    }

    class LRUCache {
        private HashMap<Integer, Node> map;
        private DoubleList cache;
        private int cap;


        public LRUCache(int capacity) {
            this.map = new HashMap<>();
            this.cache = new DoubleList();
            this.cap = capacity;
        }

        public int get(int key) {
            //1.判断是否存在
            if (!map.containsKey(key)) {
                return -1;
            } else {
                int val = map.get(key).value;
                //2.将 node 放在链表头部
                put(key, val);
                //3.返回 value
                return val;
            }
        }

        public void put(int key, int value) {
            Node x = new Node(key, value);
            if (map.containsKey(key)) {
                //删除旧节点
                cache.remove(map.get(key));
                //添加新节点
                cache.addFirst(x);
                //更新 map
                map.put(key, x);
            } else {
                if (cache.size() == cap) {
                    Node last = cache.removeLast();
                    map.remove(last.key);
                }
                cache.addFirst(x);
                map.put(key, x);
            }

        }
    }
}
