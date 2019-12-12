
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertSort {


    public static void insertSort(int[] arr) {
        if(arr == null) return ;
        for (int i = 0; i < arr.length; ++i) {
            int j = i - 1;
            int value = arr[i];
            while (j >= 0 && arr[j] > value) {
                arr[j + 1] = arr[j];
                --j;
            }
            arr[++j] = value;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public List<Integer> asList(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i : arr)
            list.add(i);
        return list;
    }

    public static void printArr(int[] arr) {
        for (int i : arr)
            System.out.print(i + ", ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3,  1};
        insertSort(arr);
        printArr(arr);

    }



}
