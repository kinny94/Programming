import java.util.Random;

// get kth largest item
// the quick select algo can be made better by selecting the median as the pivot which can gurantee O(N)
// right now the worse case is O(N2);

class QuickSelect {

    private int[] nums;

    QuickSelect(int[] nums) {
        this.nums = nums;
    }

    public void swap(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int select(int k) {
        return select(0, nums.length-1, k-1);
    }

    private int select(int firstIndex, int lastIndex, int k) {
        int pivot = partition(firstIndex, lastIndex);
        if (pivot > k) {
            return select(firstIndex, pivot - 1, k);
        } else if (pivot < k) {
            return select(pivot + 1, lastIndex, k);
        }

        return nums[k];
    }
    
    private int partition(int firstIndex, int lastIndex) {
        int pivot = new Random().nextInt(lastIndex - firstIndex + 1) + firstIndex;
        swap(lastIndex, pivot);

        for (int i=firstIndex; i<lastIndex; ++i) {
            if (nums[i] > nums[lastIndex]) { // change it to < for kth smallest item     
                swap(i, firstIndex);
                firstIndex++;
            }
        }

        swap(firstIndex, lastIndex);
        return firstIndex;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 5, 4, 8, -2};
        QuickSelect qs = new QuickSelect(nums);
        System.out.println(qs.select(2));
    }   
}