import java.util.Random;

// Our task is to design an algorithms that is capable of selecting k items from an array!. The problem is that the size of the array is unknown.
// the result would be uniformly distributed 

class ReservoirSamplingProblem {

    private Random random;

    public ReservoirSamplingProblem() {
        this.random = new Random();
    }

    // O(N) algo to get k items at random from the array nums
    public void solve(int[] nums, int k) {
        // create a new array for k items
        int[] reservoir = new int[k];

        // copy the first k elements from the original array
        for (int i=0; i<reservoir.length; i++) {
            reservoir[i] = nums[i];
        }

        // we consider the items from the original array
        // k + 1 because we have already copied k items
        // the i-th item is chosen to be included in the reservoir with the probobility k/i

        for (int i=k+1; i<nums.length; i++) {
            int j = random.nextInt(i) + 1;
            if (j<k) {
                reservoir[j] = nums[i];
            }
        }

        // show the k random items
        for (int i=0; i<reservoir.length; i++) {
            System.out.println(reservoir[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] nums = {13, 65, 46, 11, 71, 50, 12, 5, 81, 97, 28, 74, 87, 68, 42, 31, 40, 37, 43, 25};
        int k = 5;

        ReservoirSamplingProblem rsp = new ReservoirSamplingProblem();
        rsp.solve(nums, k);
    }
}