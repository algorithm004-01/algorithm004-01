package com.mrglint.leetcode.week07.solution146;

import java.util.HashMap;
import java.util.Map;

/**
 * 使用双向链表和哈希表实现
 *
 * @author luhuancheng
 * @since 2019-11-27 23:04
 */
public class LRUCache {

    private static class DoubleList {
        private static class Node {
            int key;
            int value;
            Node prev, next;

            Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private Node head, tail;
        private int size;

        DoubleList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        /**
         * 加入链表头部
         * @param x
         */
        void addFirst(Node x) {
            x.next = head.next;
            x.prev = head;
            head.next.prev = x;
            head.next = x;
            size++;
        }

        /**
         * 删除指定节点
         * @param x
         */
        void remove(Node x) {
            x.prev.next = x.next;
            x.next.prev = x.prev;
            size--;
        }

        /**
         * 删除最后一个节点
         * @return
         */
        Node removeLast() {
            if (tail.prev == head) {
                return null;
            }
            Node last = tail.prev;
            remove(last);
            return last;
        }
    }


    private int capacity;
    private Map<Integer, DoubleList.Node> map;
    private DoubleList cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        cache = new DoubleList();
    }

    /**
     * 从哈希表中获取链表节点：Node ，
     * 从链表中删除该节点，放入链表头部
     * @param key
     * @return
     */
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        int value = map.get(key).value;
        put(key, value);
        return value;
    }

    /**
     * 判断链表是否达到capacity大小，达到了则删除最后一个节点之后，放入新节点
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        DoubleList.Node node = new DoubleList.Node(key, value);
        if (map.containsKey(key)) {
            // 删除旧节点
            cache.remove(map.get(key));
            // 添加新节点
            cache.addFirst(node);
            map.put(key, node);
        } else {
            // 淘汰最后一个节点
            if (capacity == cache.size) {
                DoubleList.Node last = cache.removeLast();
                map.remove(last.key);
            }
            map.put(key, node);
            cache.addFirst(node);
        }
    }

}

