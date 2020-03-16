class RodCuttingProblem {
    
    private int[][] dpTable;
    private int lengthOfRod;
    private int[] prices;

    RodCuttingProblem(int lengthOfRod, int[] prices) {
        this.prices = prices;
        this.lengthOfRod = lengthOfRod;
        this.dpTable = new int[prices.length+1][lengthOfRod+1];
    }

    public void solve() {
        for (int i=1; i<prices.length; i++) {
            for (int j=1; j<=lengthOfRod; j++) {
                if (i <= j) {
                    dpTable[i][j] = Math.max(dpTable[i-1][j], prices[i] + dpTable[i][j-i]);
                } else {
                    dpTable[i][j] = dpTable[i-1][j];
                }
            }
        }
    }

    public void showResults() {
        System.out.println("Optimal profi: $" + dpTable[prices.length - 1][lengthOfRod]);

        for (int n=prices.length -1, w = lengthOfRod; n>0;) {
            if (dpTable[n][w] != 0 && dpTable[n][w] != dpTable[n-1][w]) {
                System.out.println("We make cut: " + n + "m");
                w = w -n;
            } else {
                n--;
            }
        }
    }

    public static void main(String[] args) {
        int length = 6;
        int[] prices = {0, 2, 5, 7, 3};
        RodCuttingProblem rcp = new RodCuttingProblem(length, prices);
        rcp.solve();
        rcp.showResults();
    }
}