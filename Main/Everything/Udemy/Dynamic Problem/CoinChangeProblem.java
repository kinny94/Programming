class CoinChangeProblem {
    
    // recursive
    public int naiveCointChange(int M, int[] v, int index) {
        if (M < 0) return 0;
        if ( M == 0) return 1;

        if ( v.length == index) {
            return 0;
        }

        return naiveCointChange(M-v[index], v, index) + naiveCointChange(M, v, index+1);
    }

    // dynamic problem solution
    public void dpCoinChange(int[] v, int M) {
        // +1 because we consider 0 as a possibility
        int[][] dpTable = new int[v.length+1][M+1];

        for (int i=0; i<=v.length; i++) {
            dpTable[i][0] = 1;
        }

        for (int i=1; i<=M; i++) {
            dpTable[0][i] = 0;
        }

        // O(v*M)
        for (int i=1; i<=v.length; i++) {
            for (int j=1; j<=M; j++) {
                if ( v[i-1] <= j ) {
                    dpTable[i][j] = dpTable[i-1][j] + dpTable[i][j-v[i-1]];
                } else {
                    // we do not take that coin
                    dpTable[i][j] = dpTable[i-1][j];
                }
            }
        
        }
        System.out.println("Solution: " + dpTable[v.length][M]);   
    }

    public static void main(String[] args) {
        int[] v = {1, 2, 3};
        int M = 5;
        CoinChangeProblem ccp = new CoinChangeProblem();
        System.out.println(ccp.naiveCointChange(M, v, 0));
        ccp.dpCoinChange(v, M);
    }
}