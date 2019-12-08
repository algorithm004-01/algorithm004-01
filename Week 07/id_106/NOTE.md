# 20191125-1201学习总结
本周学习了位运算，布隆过滤器LRU缓存的概念，以及常用的排序算法的概念

O(n^2) 排序算法
选择排序，插入排序，冒泡排序
O(nlogn) 排序算法(需要熟练掌握)
快速排序 归并排序 堆排序

代码模板：
快速排序
```java

class Quicksort{

    public static void quickSort(int[] array, int begin, int end) {
        if (end <= begin) return;
        int pivot = partition(array, begin, end);
        quickSort(array, begin, pivot - 1);
        quickSort(array, pivot + 1, end);
    }
    
    static int partition(int[] a, int begin, int end) {
        // pivot: 标杆位置，counter: 小于pivot的元素的个数
        int pivot = end, counter = begin;
        for (int i = begin; i < end; i++) {
            if (a[i] < a[pivot]) {
                int temp = a[counter]; a[counter] = a[i]; a[i] = temp;
                counter++;
            }
        }
        int temp = a[pivot]; a[pivot] = a[counter]; a[counter] = temp;
        return counter;
    }

}
```

归并排序
```java
class Mergesort{
    public static void mergeSort(int[] array, int left, int right) {

        if (right <= left) return;
        int mid = (left + right) >> 1; // (left + right) / 2
    
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);
    
    }
    
    public static void merge(int[] arr, int left, int mid, int right) {
    
            int[] temp = new int[right - left + 1]; // 中间数组
            int i = left, j = mid + 1, k = 0;
    
            while (i <= mid && j <= right) {
                temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
            }
    
            while (i <= mid)   temp[k++] = arr[i++];
            while (j <= right) temp[k++] = arr[j++];
    
            for (int p = 0; p < temp.length; p++) {
                arr[left + p] = temp[p];
            }
            // 也可以用 System.arraycopy(a, start1, b, start2, length)
        }
}
```

堆排序
```java
class Heapsort{
    static void heapify(int[] array, int length, int i) {
        int left = 2 * i + 1, right = 2 * i + 2;
        int largest = i;
    
        if (left < length && array[left] > array[largest]) {
            largest = left;
        }
        if (right < length && array[right] > array[largest]) {
            largest = right;
        }
    
        if (largest != i) {
            int temp = array[i]; array[i] = array[largest]; array[largest] = temp;
            heapify(array, length, largest);
        }
    }
    
    public static void heapSort(int[] array) {
        if (array.length == 0) return;
    
        int length = array.length;
        for (int i = length / 2-1; i >= 0; i--) 
            heapify(array, length, i);
    
        for (int i = length - 1; i >= 0; i--) {
            int temp = array[0]; array[0] = array[i]; array[i] = temp;
            heapify(array, i, 0);
        }
    }
}
```
  

