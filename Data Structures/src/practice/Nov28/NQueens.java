package practice.Nov28;

public class NQueens {

    private int[][] chessTable;
    private int numberOfQueens;

    public NQueens(int numberOfQueens) {
        this.numberOfQueens = numberOfQueens;
        this.chessTable = new int[numberOfQueens][numberOfQueens];
    }

    public void solve() {
        if (setQueens(0)) {
            printQueens();
        } else {
            System.out.println("No solution found!!");
        }
    }

    private boolean setQueens(int colIndex) {
        // base case
        if (colIndex == numberOfQueens) {
            return true;
        }

        for (int rowIndex = 0; rowIndex < numberOfQueens; rowIndex++) {
            if (isPlaceValid(rowIndex, colIndex)) {
                chessTable[rowIndex][colIndex] = 1;
                if (setQueens(colIndex + 1)) {
                    return true;
                }
                chessTable[rowIndex][colIndex] = 0;
            }
        }
        return false;
    }

    private boolean isPlaceValid(int rowIndex, int colIndex) {
        for (int i=0;i<colIndex; i++) {
            if (chessTable[rowIndex][i] == 1) {
                // same column... not possible
                return false;
            }
            //
        }

        // check the diagonal
        for (int i=rowIndex, j=colIndex;i>=0 && j>=0;i--, j--) {
            if (chessTable[i][j] == 1) {
                return false;
            }
        }
        // check the other diagonal
        for (int i=rowIndex, j=colIndex;i<chessTable.length && j>=0;i++, j--) {
            if (chessTable[i][j] == 1) {
                return false;
            }
        }
        // the position is valid
        return true;
    }

    private void printQueens() {
        for (int i = 0; i < numberOfQueens; i++) {
            for (int j = 0; j < numberOfQueens; j++) {
                if (chessTable[i][j] == 1) {
                    System.out.print(" * ");
                } else {
                    System.out.print(" - ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        NQueens nQueens = new NQueens(3);
        nQueens.solve();
        System.out.println();
        NQueens nQueens2 = new NQueens(5);
        nQueens2.solve();
    }
}
