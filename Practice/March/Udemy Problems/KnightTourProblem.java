class Constants {
    private Constants() {}

    public static final int BOARD_SIZE = 8;
    public static final int NUM_OF_MOVES = 8;
}

class KnightTourProblem {
    
    private int[][] solutionMatrix;
    private int[] xMoves = { 2, 1, -1, -2, -2, -1, 1, 2};
    private int[] ymoves = { 1, 2, 2, 1, -1, -2, -2, -1};
    
    KnightTourProblem() {
        this.solutionMatrix = new int[Constants.BOARD_SIZE][Constants.BOARD_SIZE];
        initializeBoard();
    }

    private void initializeBoard() {
        for(int i=0;i<Constants.BOARD_SIZE; i++) {
            for (int j=0; j<Constants.BOARD_SIZE; j++) {
                solutionMatrix[i][j] = Integer.MIN_VALUE;
            }
        }
    }

    public void solve(){
        this.solutionMatrix[0][0] = 1;   
        if (solve(2, 0, 0)) {
            printSolution();
        } else {
            System.out.println("No feasible solution...");
        }
    }

    private void printSolution() {
        for (int i=0; i<Constants.BOARD_SIZE; i++) {
            for (int j=0;j<Constants.BOARD_SIZE; j++) {
                System.out.print(solutionMatrix[i][j] + " ");
            }
            System.out.println(); 
        }
    }

    private boolean solve(int stepCount, int x, int y) {

        // stepped on every block of the chess board
        if (stepCount == Constants.BOARD_SIZE * Constants.BOARD_SIZE + 1) {
            return true;
        }

        for (int i=0; i<Constants.NUM_OF_MOVES; i++) {
            int nextX= x + xMoves[i];
            int nextY = y + ymoves[i];

            if (isStepValid(nextX, nextY)) {
                solutionMatrix[nextX][nextY] = stepCount;
                if (solve(stepCount+1, nextX, nextY)) {
                    return true;
                }

                // backtrack
                solutionMatrix[nextX][nextY] = Integer.MIN_VALUE;
            }
        }

        return false;
    }

    private boolean isStepValid(int x, int y) {

        // check if we are outside the chessboard
        if (x<0 || x>=Constants.BOARD_SIZE) {
            return false;
        }

        if (y<0|| y>=Constants.BOARD_SIZE) {
            return false;
        }

        if (solutionMatrix[x][y] != Integer.MIN_VALUE) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {

        KnightTourProblem kt = new KnightTourProblem();
        kt.solve();
    }
}