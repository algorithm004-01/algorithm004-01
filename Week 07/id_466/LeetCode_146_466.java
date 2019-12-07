//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
//
// 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
//写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
//
// 进阶:
//
// 你是否可以在 O(1) 时间复杂度内完成这两种操作？
//
// 示例:
//
// LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // 返回  1
//cache.put(3, 3);    // 该操作会使得密钥 2 作废
//cache.get(2);       // 返回 -1 (未找到)
//cache.put(4, 4);    // 该操作会使得密钥 1 作废
//cache.get(1);       // 返回 -1 (未找到)
//cache.get(3);       // 返回  3
//cache.get(4);       // 返回  4
//
// Related Topics 设计
package com.aseara.leetcode.editor.cn.a146;

import java.util.HashMap;
import java.util.Map;

/**
 * desc: 146.LRU缓存机制 <br />
 * Date: 2019/11/26 <br/>
 *
 * @author qiujingde
 */
class LruCacheTest {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 );

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));    // 1
        cache.put(3, 3);
        System.out.println(cache.get(2));    // -1
        cache.put(4, 4);
        System.out.println(cache.get(1));    // -1
        System.out.println(cache.get(3));    // 3
        System.out.println(cache.get(4));


        cache = new LRUCache( 3 );
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4);

        System.out.println(cache.get(4));    // 4
        System.out.println(cache.get(3));    // 3
        System.out.println(cache.get(2));    // 2
        System.out.println(cache.get(1));    // -1

        cache.put(5, 5);
        System.out.println(cache.get(1));    // -1
        System.out.println(cache.get(2));    // 2
        System.out.println(cache.get(3));    // 3
        System.out.println(cache.get(4));    // -1
        System.out.println(cache.get(5));    // 5
    }
}


//leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {

    private Map<Integer, Node> map = new HashMap<>();
    private Deque deque = new Deque();
    private int remain;

    public LRUCache(int capacity) {
        this.remain = capacity;
    }

    public int get(int key) {
        Node node = getNode(key);
        return node == null ? -1 : node.val;
    }

    public void put(int key, int value) {
        Node node = getNode(key);
        if (node != null) {
            node.val = value;
            return;
        }
        node = new Node(key, value);
        deque.add(node);
        map.put(key, node);
        if (remain > 0) {
            remain --;
            return;
        }
        Node remove = deque.remove();
        map.remove(remove.key);
    }

    private Node getNode(int key) {
        Node node = map.get(key);
        if (node == null) {
            return null;
        }
        deque.remove(node);
        deque.add(node);
        return node;
    }

    static class Deque {
        Node head = new Node(0, 0);
        Node tail = new Node(0, 0);

        Deque() {
            tail.pre = head;
            head.next = tail;
        }

        void add(Node node) {
            node.pre = head;
            node.next = head.next;
            head.next.pre = node;
            head.next = node;
        }

        void remove(Node node) {
            Node pre = node.pre;
            Node next = node.next;
            pre.next = next;
            next.pre = pre;
        }

        Node remove() {
            if (tail.pre == head) {
                return null;
            }
            Node result = tail.pre;
            result.pre.next = tail;
            tail.pre = result.pre;
            return result;
        }
    }

    static class Node {
        final int key;
        int val;
        Node pre;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
