class KnapsackProblem {

    private int numOfItems;
    private int knapsackCapacity;
    private int[][] knapsackTable;
    private int totalBenefit;
    private int[] weights;
    private int[] values;

    KnapsackProblem(int numOfItems, int knapsackCapacity, int[] weights, int[] values) {
        this.numOfItems = numOfItems;
        this.knapsackCapacity = knapsackCapacity;
        this.weights = weights;
        this.values = values;     
        this.knapsackTable = new int[numOfItems+1][knapsackCapacity+1];
    }

    public void solve() {
		
		// time complexity: O(N*W)
		for(int i=1;i<numOfItems+1;i++) {
			for(int w=1;w<knapsackCapacity+1;w++) {
				
				int notTakingItem = knapsackTable[i-1][w]; // not taking item i
				int takingItem = 0;
				
				if( weights[i] <= w ) {
					takingItem = values[i] + knapsackTable[i-1][w-weights[i]]; 
				}
				
				knapsackTable[i][w] = Math.max(notTakingItem, takingItem);
			}
		}
		
		totalBenefit = knapsackTable[numOfItems][knapsackCapacity];
    }
    
    public void showResult() {
        System.out.println("Total benefit: " + totalBenefit);

        for (int n=numOfItems, w=knapsackCapacity; n>0; n--) {
            if (knapsackTable[n][w] != 0) {
                if (knapsackTable[n][w] != 0 && knapsackTable[n][w] != knapsackTable[n-1][w]) {
                    System.out.println ("We take item: #" + n);
                    w = w - weights[n];
                }
            }
        }
    }

    public static void main(String[] args) {
        int numOfItems = 3;
        int knapsackCapacity = 5;
        
        // int[] weights = {4, 2, 3};
        // int[] profit = {10, 4, 7};

        int[] weights = new int[numOfItems + 1];
        weights[1] = 4;
        weights[2] = 2;
        weights[3] = 3;

        int[] profit = new int[numOfItems + 1];
        profit[1] = 10;
        profit[2] = 4;
        profit[3] = 7;

        KnapsackProblem kp = new KnapsackProblem(numOfItems, knapsackCapacity, weights, profit);
        kp.solve();
        kp.showResult();
    }
}