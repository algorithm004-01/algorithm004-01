package com.lqw.algorithm.cache;

import java.util.HashMap;

/**
 * 最近最少使用
 * LRUCache使用hashMap加双向链表实现
 * hashMap快速获取数据get（key），时间复杂度O（1）
 * 双向链表实现缓存数据的快速删除，移动
 * https://leetcode-cn.com/problems/lru-cache/
 *
 * @author linqiwen
 */
public class LRUCache {

    /**
     * 缓存容量
     */
    private final int capacity;

    /**
     * 用于加速缓存项随机访问性能的HashMap
     */
    private HashMap<Integer, Entry> dataMap;

    /**
     * 双向链表头节点，该侧的缓存项访问时间较早
     */
    private Entry head;

    /**
     * 双向链表尾节点，该侧的缓存项访问时间较晚
     */
    private Entry tail;

    public LRUCache(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Illegal initial capacity: " +
                    initialCapacity);
        }
        this.capacity = initialCapacity;
        dataMap = new HashMap<>(capacity);
        head = new Entry(0, 0);
        tail = new Entry(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public Integer get(Integer key) {
        Integer value = null;
        if (dataMap.containsKey(key)) {
            Entry entry = dataMap.get(key);
            if (entry != null) {
                value = entry.value;
                popToTail(entry);
            }
        }
        return value;
    }

    public void set(Integer key, Integer value) {
        if (key == null || value == null) {
            return;
        }
        if (dataMap.containsKey(key)) {
            Entry oldEntry = dataMap.get(key);
            if (oldEntry != null) {
                oldEntry.value = value;
                popToTail(oldEntry);
                return;
            }
        }
        Entry entry = new Entry(key, value);
        if (dataMap.size() >= capacity) {
            Entry firstEntry = head.next;
            removeFirst(firstEntry);
        }
        dataMap.put(key, entry);
        addTotail(entry);
    }

    private void removeFirst(Entry firstEntry) {
        Entry prev = firstEntry.prev;
        Entry next = firstEntry.next;
        prev.next = next;
        next.prev = prev;
        dataMap.remove(firstEntry.key);
    }

    private void popToTail(Entry entry) {
        Entry prevEntry = entry.prev;
        Entry nextEntry = entry.next;
        if (nextEntry == tail) {
            return;
        }
        prevEntry.next = nextEntry;
        nextEntry.prev = prevEntry;
        Entry tailPrevEntry = tail.prev;
        tailPrevEntry.next = entry;
        entry.prev = tailPrevEntry;
        entry.next = tail;
        tail.prev = entry;
    }

    private void addTotail(Entry entry) {
        Entry tailPrev = tail.prev;
        tailPrev.next = entry;
        entry.prev = tailPrev;
        entry.next = tail;
        tail.prev = entry;
    }

    class Entry {

        Integer key;

        Integer value;

        Entry prev;

        Entry next;

        Entry(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    public HashMap<Integer, Entry> getDataMap() {
        return dataMap;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(10);
        lruCache.set(1, 1);
        lruCache.set(2, 2);
        lruCache.set(3, 3);
        lruCache.set(4, 4);
        lruCache.set(5, 5);
        lruCache.set(6, 6);
        lruCache.set(7, 7);
        lruCache.set(8, 8);
        lruCache.set(9, 9);
        lruCache.set(10, 10);
        System.out.println(lruCache.getDataMap());
        lruCache.get(1);
        lruCache.get(2);
        System.out.println(lruCache.getDataMap());
        lruCache.set(11, 11);
        lruCache.set(12, 12);
        System.out.println(lruCache.getDataMap());

    }
}















































































































