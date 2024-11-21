package algorithms.Backtracking;

public class KnightTourProblem {

    private int[][] chessTable;
    private int boardSize;
    private int[] xMoves = {2, 1, -1, -2, -2, -1, 1, 2};
    private int[] yMoves = {1, 2, 2, 1, -1, -2, -2, -1};

    KnightTourProblem(int boardSize) {
        this.boardSize = boardSize;
        this.chessTable = new int[boardSize][boardSize];
        initializeChessTable();
    }

    private void initializeChessTable() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                chessTable[i][j] = -1;
            }
        }
    }

    public void solve() {
        chessTable[0][0] = 0;
        if (findSolution(1, 0, 0)) {
            showSolution();
        } else {
            System.out.println("No solution found");
        }
    }

    private boolean findSolution(int stepCount, int x, int y) {
        // base case
        if (stepCount == boardSize * boardSize) {
            return true;
        }

        for (int i = 0; i < xMoves.length; i++) {
            int newX = x + xMoves[i];
            int newY = y + yMoves[i];
            if (isValid(newX, newY)) {
                chessTable[newX][newY] = stepCount;
                if (findSolution(stepCount+1, newX, newY)) {
                    return true;
                }
                chessTable[newX][newY] = -1;
            }
        }
        return false;
    }

    private boolean isValid(int x, int y) {
        // checking the boardSize
        if (x < 0 || x >= boardSize || y < 0 || y >= boardSize) {
            return false;
        }

        return chessTable[x][y] == -1;
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
        KnightTourProblem knightTourProblem = new KnightTourProblem(4);
        knightTourProblem.solve();
    }
}
