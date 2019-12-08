package com.markdown.leetcode.editor.cn;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * 排序算法
 *
 * @author Mark Li
 * @version 1.0.0
 * @since 2019/12/1
 */
public class Sort {

    public static void main(String[] args) {

        int[] array = new int[10];
        Random random = new Random(10);
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
            System.out.println(array[i]);
        }

        Sort sort = new Sort();

        // sort.bubbleSort(array);

        // sort.insertionSort(array);

        // sort.selectionSort(array);

        // sort.quickSort(array);

        // sort.mergeSort(array);

        sort.heapSort(array);

        System.out.println("----------");
        for (int i : array) {
            System.out.println(i);
        }
    }

    /**
     * 冒泡排序
     * 稳定
     */
    private void bubbleSort(int[] array) {

        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 插入排序
     * 稳定
     */
    private void insertionSort(int[] array) {

        int length = array.length;
        for (int i = 1; i < length; i++) {
            int current = array[i];
            int pre = i - 1;
            while (pre >= 0 && array[pre] > current) {
                array[pre + 1] = array[pre];
                pre--;
            }
            array[pre + 1] = current;
        }
    }

    /**
     * 选择排序
     * 不稳定
     */
    private void selectionSort(int[] array) {

        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < length; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }
            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
    }

    /**
     * 快速排序
     * 不稳定
     */
    private void quickSort(int[] array) {

        quickSort(array, 0, array.length - 1);
    }
    private void quickSort(int[] array, int begin, int end) {

        if (begin >= end) return;

        int pivot = partition(array, begin, end);
        quickSort(array, begin, pivot - 1);
        quickSort(array, pivot + 1, end);
    }
    private int partition(int[] array, int begin, int end) {
        // 小于 array[pivot] 的元素个数
        int counter = begin;
        for (int i = begin; i < end; i++) {
            if (array[i] < array[end]) {
                int temp = array[counter];
                array[counter] = array[i];
                array[i] = temp;
                counter++;
            }
        }
        int temp = array[end];
        array[end] = array[counter];
        array[counter] = temp;
        return counter;
    }

    /**
     * 归并排序
     * 稳定
     */
    private void mergeSort(int[] array) {

        mergeSort(array, 0, array.length - 1);
    }
    private void mergeSort(int[] array, int begin, int end) {

        if (begin >= end) return;
        int middle = begin + (end - begin) / 2;
        mergeSort(array, begin, middle);
        mergeSort(array, middle + 1, end);
        merge(array, begin, middle, end);
    }
    private void merge(int[] array, int begin, int middle, int end) {

        int left = begin, right = middle + 1;
        int[] temp = new int[end - begin + 1];
        int tempIndex = 0;
        while (left <= middle && right <= end) {
            temp[tempIndex++] = array[left] <= array[right] ? array[left++] : array[right++];
        }
        while (left <= middle) {
            temp[tempIndex++] = array[left++];
        }
        while (right <= end) {
            temp[tempIndex++] = array[right++];
        }
        for (int num: temp) {
            array[begin++] = num;
        }
    }

    /**
     * 堆排序
     * 不稳定
     */
    private void heapSort(int[] array) {

        PriorityQueue<Integer> queue = new PriorityQueue<>(array.length);
        for (int num : array) {
            queue.offer(num);
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = queue.poll();
        }
    }
}
