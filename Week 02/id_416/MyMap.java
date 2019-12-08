package com.leetcode.week02.util;

public interface MyMap<K,V> {

    //向集合中插入值
    public V put(K k,V v);
    //向集合中取值
    public V get(K k);
    //集合数据的个数
    public int size();
    //用于获取集合中，键值对的对象
    interface Entry<K,V> {
        K getKey();
        V getValue();
        V setValue(V value);
        Entry<K,V> getNext();
        Entry<K,V> setNext(Entry<K,V> next);
    }
}
