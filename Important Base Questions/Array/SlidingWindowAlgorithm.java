/*
    Given an array and integer k, write an algorithm to find the maximum element in each subarray of size k.

    int [] nums = { 1, 2, 3, 2, 4, 1, 5, 6,1};
    Output: 3, 3, 4, 4, 5, 6, 6
    Subarrays –
    [1, 2, 3], max = 3
    [2, 3, 2], max = 3
    [3, 2, 4], max = 4
    [2, 4, 1], max = 4
    [4, 1, 5], max = 5
    [1, 5, 6], max = 6
    [5, 6, 1], max = 6'

    

*/

class SlidingWindowAlgorithm{
    
    public int solve(int[] a, int k) {
        if (k > a.length) {
            return -1;
        }

        int maxSum = 0;
        int windowSum = 0;


        for (int i=0; i<k; i++) {
            maxSum += a[i];
        }

        windowSum = maxSum;

        for (int i=k; i<a.length; i++) {
            windowSum = windowSum - a[i-k] + a[i];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }
    public static void main(String[] args) {
        int arr[] = { 1, 4, 2, 10, 2, 3, 1, 0, 20 }; 
        int k = 4; 
        SlidingWindowAlgorithm algo = new SlidingWindowAlgorithm();
        System.out.println(algo.solve(arr, k)); 
    }
}