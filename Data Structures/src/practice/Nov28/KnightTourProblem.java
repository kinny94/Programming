package practice.Nov28;

public class KnightTourProblem {

    private int[][] chessTable;
    private int boardSize;
    private int[] xMoves = {2, 1, -1, -2, -2, -1, 1, 2};
    private int[] yMoves = {1, 2, 2, 1, -1, -2, -2, -1};

    public KnightTourProblem(int boardSize) {
        this.boardSize = boardSize;
        this.chessTable = new int[boardSize][boardSize];

        for (int i=0; i<boardSize; i++) {
            for (int j=0; j<boardSize; j++) {
                chessTable[i][j] = -1;
            }
        }
    }


    public void solve() {
        chessTable[0][0] = 0;
        if (findSolution(1, 0, 0)) {
            showSolution();
        } else {
            System.out.println("No solution is possible!!");
        }
    }

    private boolean findSolution(int stepCount, int xCoordinate, int yCoordinate) {
        if (stepCount == boardSize * boardSize) {
            return true;
        }

        // try all the boxes
        for (int i=0;i<xMoves.length; i++) {
            int newX = xCoordinate + xMoves[i];
            int newY = yCoordinate + yMoves[i];
            if (isPositionValid(newX, newY)) {
                chessTable[newX][newY] = stepCount;
                if (findSolution(stepCount + 1, newX, newY)) {
                    return true;
                }
                // backtrack
                chessTable[newX][newY] = -1;
            }
        }
        return false;
    }

    private boolean isPositionValid(int xCoordinate, int yCoordinate) {
        if (xCoordinate < 0 || xCoordinate >= boardSize || yCoordinate < 0 || yCoordinate >= boardSize) {
            return false;
        }
        return chessTable[xCoordinate][yCoordinate] == -1;
    }
 
    private void showSolution() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                System.out.print(chessTable[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        KnightTourProblem knightTourProblem = new KnightTourProblem(5);
        knightTourProblem.solve();
    }
    
}
