
public class MergeSort {

    //[i, j]
    private void mergeSort(int[] arr, int l, int r) {
        if(l >= r)
            return ;

        int mid = (l + r) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    //合并区间 ----> [l, mid]  [mid + 1, r]
    public void merge(int[] arr, int l, int mid, int r) {
        int pL = l;
        int pR = mid + 1;

        int hIndex = 0;
        int[] help = new int[r - l + 1];

        while(pL <= mid && pR <= r)
            help[hIndex++] = arr[pL] < arr[pR] ? arr[pL++] : arr[pR++];

        while(pL <= mid)
            help[hIndex++] = arr[pL++];

        while(pR <= r)
            help[hIndex++] = arr[pR++];

        for (int i = l; i <= r; ++i)
            arr[i] = help[i - l];
    }

}
