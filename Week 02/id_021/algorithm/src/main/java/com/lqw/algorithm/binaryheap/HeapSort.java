package com.lqw.algorithm.binaryheap;

import java.util.Arrays;

/**
 * 使用大项堆堆排序
 *
 * @author linqiwen
 */
public class HeapSort {

    class Heap {
        private int count;
        private int[] content;

        Heap(int size) {
            if (size < 1) {
                throw new IllegalArgumentException("size is illegal");
            }
            count = 0;
            content = new int[size + 1];
        }

        boolean insertData(int data) {
            if (count >= content.length) {
                return false;
            }
            count++;
            content[count] = data;
            heapifyDownToUp(content, count);
            return true;
        }

        boolean removeMax() {
            if (count == 0) {
                return Boolean.FALSE;
            }
            content[1] = content[count];
            count--;
            heapifyUpToDown(content, 1, count);
            return Boolean.TRUE;
        }

        int[] sort() {
            int k = count;
            if (k == 1) {
                return content;
            }
            while (true) {
                swap(content, 1, k);
                if (k == 1) {
                    break;
                }
                k--;
                heapifyUpToDown(content, 1, k);
            }
            return content;
        }
    }

    public void sort(int[] content) {
        Heap heap = buildHeap(content);
        heap.sort();
    }

    private Heap buildHeap(int[] content) {
        Heap heap = new Heap(content.length + 1);
        for (int data : content) {
            heap.insertData(data);
        }
        return heap;
    }

    private void swap(int[] content, int index, int swapIndex) {
        int temp = content[swapIndex];
        content[swapIndex] = content[index];
        content[index] = temp;
    }

    private void heapifyUpToDown(int[] content, int index, int count) {
        while (true) {
            int maxIndex = index;
            if (2 * index < count && content[index] < content[2 * index]) {
                maxIndex = 2 * index;
            }
            if ((2 * index + 1) < count && content[maxIndex] < content[2 * index + 1]) {
                maxIndex = 2 * index + 1;
            }
            if (maxIndex == index) {
                break;
            }
            swap(content, maxIndex, index);
            index = maxIndex;
        }
    }

    private void heapifyDownToUp(int[] content, int index) {
        boolean flag = true;
        while (flag) {
            flag = false;
            int parentIndex = index / 2;
            if (index > 1 && content[parentIndex] < content[index]) {
                flag = true;
                swap(content, parentIndex, index);
                index = parentIndex;
            }
        }
    }
}
