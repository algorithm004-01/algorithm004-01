package com.lqw.algorithm.binaryheap;

/**
 * 大项堆，不是线程安全的
 *
 * @author linqiwen
 */
public class BigHeap {

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

    public BigHeap(int capacity) {
        this.size = capacity;
        count = 0;
        datas = new int[capacity + 1];
    }

    /**
     * 插入
     */
    public boolean insert(int data) {
        //堆满了
        if (count >= size) {
            return false;
        }
        count++;
        datas[count] = data;
        int i = count;
        //插入i的父节点i/2,堆化
        while (i / 2 > 0 && datas[i] > datas[i / 2]) {
            swap(datas, i, i / 2);
            i = i / 2;
        }
        return true;
    }

    /**
     * 删除
     */
    public boolean removeMax() {
        //堆中没有数据
        if (count == 0) {
            return false;
        }
        datas[1] = datas[count];
        count--;
        heapify(datas, count, 1);
        return true;
    }

    /**
     * 自上往下堆化
     */
    private void heapify(int[] datas, int count, int headIndex) {
        while (true) {
            int maxPos = headIndex;
            //从左右子节点中获取最大值
            if (2 * headIndex <= count && datas[2 * headIndex] > datas[maxPos]) {
                maxPos = 2 * headIndex;
            }
            if ((2 * headIndex + 1) <= count && datas[2 * headIndex + 1] > datas[maxPos]) {
                maxPos = 2 * headIndex + 1;
            }
            if (headIndex == maxPos) {
                break;
            }
            swap(datas, headIndex, maxPos);
            headIndex = maxPos;
        }
    }

    /**
     * 交换数据
     */
    private void swap(int[] datas, int swapOneIndex, int swapTwoIndex) {
        int temp = datas[swapOneIndex];
        datas[swapOneIndex] = datas[swapTwoIndex];
        datas[swapTwoIndex] = temp;
    }
}



















































































