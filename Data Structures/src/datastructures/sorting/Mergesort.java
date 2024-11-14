package datastructures.sorting;

public class Mergesort {

    private int[] nums;

    private int[] tempArray;

    public Mergesort(int[] nums) {
        this.nums = nums;
        this.tempArray = new int[nums.length];
    }

    public void swap(int i, int j) {
        int temp = tempArray[i];
        tempArray[i] = tempArray[j];
        tempArray[j] = temp;
    }

    public void showArray() {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public void sort() {
        mergeSort(0, nums.length - 1);
    }

    private void mergeSort(int low, int high) {
        if (low >= high) {
            return;
        }

        int mid = (low + high) / 2;

        // keep splitting the problem until we have one element per array
        mergeSort(low, mid);
        mergeSort(mid + 1, high);

        // we have to combine the results from sub results
        merge(low, mid, high);
    }

    private void merge(int low, int mid, int high) {
        // copy the items into the temp array
        for (int i = low; i <= high; i++) {
            tempArray[i] = nums[i];
        }

        int i = low;
        int j = mid + 1;
        int k = low;

        // we consider the temp array and copy the items into nums
        while (i <= mid && j <= high) {
            if (tempArray[i] < tempArray[j]) {
                nums[k] = tempArray[i];
                ++i;
            } else {
                nums[k] = tempArray[j];
                ++j;
            }
            ++k;
        }

        // we have to copy the items from the left subarray
        while (i <= mid) {
            nums[k] = tempArray[i];
            ++k;
            ++i;
        }

        // we have to copy the items from the right sub array
        while (j <= high) {
            nums[k] = tempArray[j];
            ++k;
            ++j;
        }
    }

    public static void main(String[] args) {
        Mergesort mergesort = new Mergesort(new int[]{45,2,54,14,-5});
        mergesort.sort();
        mergesort.showArray();
    }
}
