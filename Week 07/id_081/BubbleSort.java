
public class BubbleSort {

    public void bubbleSort(int[] arr) {
        for(int i = arr.length - 1; i >= 0; --i)
            for(int j = 0; j < i; ++j)
                if(arr[j] > arr[j + 1])
                    swap(arr, j, j + 1);
    }


    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
