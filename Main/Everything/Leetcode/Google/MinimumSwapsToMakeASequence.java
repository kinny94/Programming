class MinimumSwapsToMakeASequence {
    public int minSwap(int[] A, int[] B) {
       if(A.length == 0 ) return 0;
        int originalCost = 0;
        int swapCost = 1;
        int max = Integer.MAX_VALUE;
        for(int i = 1; i < A.length; i ++) {
            // calculate current original cost
            int originalCostWithOriginal = max;
            int originalCostWithSwap = max;
            int swapCostWithOriginal = max;
            int swapCostWithSwap = max;

            if(A[i] > A[i-1] && B[i] > B[i-1]) {
                originalCostWithOriginal = originalCost;
                swapCostWithSwap = swapCost + 1;
            }
            if(A[i] > B[i-1] && B[i] > A[i-1]) {
                originalCostWithSwap = swapCost;
                swapCostWithOriginal = originalCost + 1;
            }

            originalCost = Math.min(originalCostWithOriginal, originalCostWithSwap);
            swapCost = Math.min(swapCostWithOriginal, swapCostWithSwap);
        }
        return Math.min(originalCost, swapCost);
    }
}