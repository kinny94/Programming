package Implementations;

import java.util.Arrays;

public class QuickSort {

    private void swap(int[] arr, int  i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = start - 1;
        
        for (int j=start; j<end; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, end);
        return i + 1;
    }

    private void quicksort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int p = partition(arr, start, end);
        quicksort(arr, start, p - 1);
        quicksort(arr, p + 1, end);
    }

    public void sort(int[] arr) {
        quicksort(arr, 0, arr.length - 1);
    }
    public static void main(String[] args) {
        int[] arr = new int[]{10, 5, 1, 0, 7, 6};
        QuickSort qs = new QuickSort();
        qs.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
