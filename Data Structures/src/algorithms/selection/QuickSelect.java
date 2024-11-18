package algorithms.selection;

import java.util.Random;

public class QuickSelect {

    private int[] nums;

    public QuickSelect(int[] nums) {
       this.nums = nums;
    }

    public int find(int k) {
        return quickSelect(0, nums.length - 1, k-1);
    }

    private int quickSelect(int first, int last, int k) {
        int pivotIndex = partition(first, last);
        if (pivotIndex < k) {
            // discard the left subarray
            return quickSelect(pivotIndex + 1, last, k);
        } else  if (pivotIndex > k) {
            // discard the right sub array
            return quickSelect(first, pivotIndex - 1, k);
        }
        return nums[pivotIndex];
    }

    private int partition(int first, int last) {
        int pivot = new Random().nextInt(last - first + 1) + first;
        swap(pivot, last);

        for (int i=first; i<last; ++i) {
            if (nums[i] < nums[last]) { //nums[i] > nums[last] for largest
                swap(i, first);
                first++;
            }
        }

        swap(last, first);
        return first;
    }

    private void swap(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, -5, 10, 55, 2, 3, -7, 7, 11, 100};
        QuickSelect quickSelect = new QuickSelect(nums);
        System.out.println(quickSelect.find(3));
    }
}
