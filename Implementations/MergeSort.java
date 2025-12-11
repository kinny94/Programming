package Implementations;

class MergeSort {
    
    public void sort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    public void mergeSort(int[] arr, int start, int end) {
        if (arr == null || arr.length == 0) {
            return;
        }

        if (start >= end) {
            return;
        }

        int mid = (start + end)/ 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, end);
    }

    private void merge(int[] arr, int start, int end) {
        int i = start;
        int mid = (start + end) / 2;
        int j = mid + 1;
        int k = 0;
        int[] temp = new int[end - start + 1];

        while (i <= mid && j <= end) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            temp[k] = arr[i];
            i++;
            k++;
        } 

        while (j <= end) {
            temp[k] = arr[j];
            j++;
            k++;
        }

        int t = 0;
        for (int idx=start; idx <= end; idx++) {
            arr[idx] = temp[t];
            t++;
        }
    }
    
    public static void main(String[] args) {
        int[] arr = new int[]{10, 5, 2, 0, 7, 6, 4};
        MergeSort sort = new MergeSort();
        sort.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}