package algorithms.DynamicProgramming;

public class Knapsack {

    private int numOfItems;
    private int maxCapacity;
    private int[][] dp;
    private int[] weights;
    private int[] values;

    Knapsack(int numOfItems, int maxCapacity, int[] weights, int[] values) {
        this.numOfItems = numOfItems;
        this.maxCapacity = maxCapacity;
        this.weights = weights;
        this.values = values;
        this.dp = new int[numOfItems + 1][maxCapacity + 1];
    }

    public void solve() {
        for (int i=1; i<numOfItems + 1; i++) { // 0 row will always be 0 - no. items = 0
            for (int j=1; j<maxCapacity + 1; j++) { // 0 at column will always be 0  max weight = 0
                // we have to consider whether to consider the current item of not
                // we take the maximum of case 1: value without considering the item case 2: value with considering the item
                int notConsidering = dp[i-1][j]; // visualize it - in the above row we considered the best case of considering this item
                int consideringItem = 0; // because first we have to check if we can take the current item or not based on weight left
                if (weights[i] <= j) {
                    consideringItem = values[i] + dp[i-1][j - weights[i]]; // considering the above row and subtracting the weight of current item
                }
                dp[i][j] = Math.max(consideringItem, notConsidering);
            }
        }
        showResult();
    }

    public void showResult() {
        System.out.println("Total benefits: " + dp[numOfItems][maxCapacity]);
        for (int i=numOfItems, w=maxCapacity; i>0; i--) {
            if (dp[i][w] != 0 && dp[i][w] != dp[i-1][w]) {
                System.out.println("We take item " + i);
                w = w - weights[i];
            }
        }
    }

    public static void main(String[] args) {
        Knapsack knapsack = new Knapsack(4, 7, new int[]{0, 1, 3, 4, 5}, new int[]{0, 1, 4, 5, 7});
        knapsack.solve();
    }
}
