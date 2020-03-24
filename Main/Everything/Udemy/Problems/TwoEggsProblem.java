class TwoEggsProblem {

    private static final int NUM_OF_EGGS = 2;
    private static final int NUM_OF_FLOORS = 100;

    private int[][] dpTable = new int[NUM_OF_EGGS+1][NUM_OF_FLOORS+1];

    public int solve() {
        dpTable[0][0] = 1;
        dpTable[1][0] = 1;

        for (int i=0; i<NUM_OF_FLOORS; i++) {
            dpTable[1][i] = i;
        }

        // i is the index for the eggs
        // j = index for the floors
        for (int n=2;n<=NUM_OF_EGGS; n++) {
            for (int m=1; m<=NUM_OF_FLOORS; m++) {
                dpTable[n][m] = Integer.MAX_VALUE;

                // we are gonna use reuse the value from the dbtable
                for (int x = 1; x<=m; x++) {
                    int maxDrop = 1 + Math.max(dpTable[n-1][x-1], dpTable[n][m-x]);

                    if (maxDrop < dpTable[n][m]) {
                        dpTable[n][m] = maxDrop;
                    }
                }
            }
        }

        return dpTable[NUM_OF_EGGS][NUM_OF_FLOORS];
    }

    public static void main(String[] args) {
        TwoEggsProblem prob = new TwoEggsProblem();
        System.out.println(prob.solve())    ;
    }
}