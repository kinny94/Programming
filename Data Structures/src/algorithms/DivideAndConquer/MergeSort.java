package algorithms.DivideAndConquer;

public class MergeSort {

    private int[] nums;
    private int[] tempArray;

    public MergeSort(int[] nums) {
        this.nums = nums;
        tempArray = new int[nums.length];
    }

    public void sort() {
        mergeSort(0, nums.length - 1);
    }

    private void mergeSort(int low, int high) {
        // base case
        if (low >= high) {
            return;
         }

        int middle = (low + high) / 2;

        // we keep splitting the problem into smaller sub problems until there is only 1 item in the subarray
        mergeSort(low, middle);
        mergeSort(middle + 1, high);

        // we have to combine the solution
        merge(low, middle, high);
    }

    private void merge(int low, int middle, int high) {
        // copy the item into the temporary array
        for (int i = low; i <= high; i++) {
            tempArray[i] = nums[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;

        // we consider the temp array and copy the items into the nums
        while (i <= middle && j <= high) {
            if (tempArray[i] <= tempArray[j]) {
                nums[k] = tempArray[i];
                ++i;
            }  else {
                nums[k] = tempArray[j];
                ++j;
            }
            ++k;
        }

        // we have to copy the items from the left subarray if there are any
        while (i <= middle) {
            nums[k] = tempArray[i];
            ++k;
            ++i;
        }

        // we have to copy the items from the right subarray if there are any
        while (j <= high) {
            nums[k] = tempArray[j];
            ++k;
            ++j;
        }
     }

    private void showArray() {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    private void swap(int i, int j) {
        int temp = tempArray[i];
        tempArray[i] = tempArray[j];
        tempArray[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {5, -1, 0, 7, 2, 3, 2, 1, 0, 1, 2};
        MergeSort mergeSort = new MergeSort(nums);
        mergeSort.sort();
        mergeSort.showArray();
    }
}
