package com.lqw.algorithm.binaryheap;

/**
 * 小项堆
 *
 * @author linqiwen
 */
public class SmallHeap {

    /**
     * 堆能存储大小
     */
    private int size;

    /**
     * 存储数据数组，从下标1开始存储数据
     */
    private int[] datas;

    /**
     * 目前堆中的数据，容量
     */
    private int count;

    public SmallHeap(int capacity) {
        this.size = capacity;
        this.count = 0;
        this.datas = new int[capacity + 1];
    }

    /**
     * 插入
     */
    public boolean insert(int data) {
        return true;
    }

    /**
     * 删除
     */
    public boolean remove() {
        return true;
    }

    /**
     * 堆化
     */
    public void heapify() {

    }

    /**
     * 交换数据
     */
    public void swap() {

    }
}
