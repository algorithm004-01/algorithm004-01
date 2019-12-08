public class QuickSort {

    private void quickSort(int[] arr, int l, int r) {
        if (l >= r)
            return;

        int[] res = partition(arr, l, r);
        quickSort(arr, l, res[0]);
        quickSort(arr, res[1], r);
    }

    private int[] partition(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        int i = l;

        while (i < more) {
            if (arr[i] < arr[r])
                swap(arr, i++ , ++less);
            else if(arr[i] > arr[r])
                swap(arr, i, --more);
            else
                ++i;
        }

        swap(arr, more++, r);

        return new int[]{less, more};
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
