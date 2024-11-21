package algorithms.Backtracking;

class Constants {
    private Constants() {}
    public static final int BOARD_SIZE = 9;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;
    public static final int BOX_SIZE = 3;
}

class Sudoku {

    private int[][] table;

    Sudoku(int[][] table) {
        this.table = table;
    }

    public void solve() {
        if (findSolution(0, 0)) {
            showSolution();
        } else {
            System.out.println("there is no solution");
        }
    }

    private boolean findSolution(int rowIndex, int colIndex) {
        // check the base case
        if (rowIndex == Constants.BOARD_SIZE) {
            colIndex++;
            // we have considered all the cells - end of algorithm
            if (colIndex == Constants.BOARD_SIZE) {
                return true;
            } else {
                // hop to the next column so re-initialize rowIndex = 0
                rowIndex = 0;
            }
        }

        if (table[rowIndex][colIndex] != 0) {
            return findSolution(rowIndex + 1, colIndex);
        }

        // consider all numbers from  1 - 9
        for (int i=Constants.MIN_NUMBER; i<=Constants.MAX_NUMBER; i++) {
            if (isValid(rowIndex, colIndex, i)) {
                this.table[rowIndex][colIndex] = i;
                if (findSolution(rowIndex + 1, colIndex)) {
                    return true;
                }
                // 0 means it's an empty cell - BACKTRACK
                this.table[rowIndex][colIndex] = 0;
            }
        }
        return false;
    }

    private boolean isValid(int rowIndex, int colIndex, int num) {

        // if the given number is already in the column
        for (int i=0; i<Constants.BOARD_SIZE; i++) {
            if (table[i][colIndex] == num) {
                return false;
            }
        }

        // if the given number is already in the row
        for (int i=0 ; i<Constants.BOARD_SIZE; i++) {
            if (table[rowIndex][i] == num) {
                return false;
            }
        }

        // if the number is already in the box
        int boxRowOffset = (rowIndex / 3) * Constants.BOX_SIZE;
        int boxColumnOffset = (colIndex / 3) * Constants.BOX_SIZE;

        // all the 9 items of the given box
        for (int i=0 ; i<Constants.BOX_SIZE ; i++) {
            for (int j=0 ; j<Constants.BOX_SIZE ; j++) {
                if (table[boxRowOffset + i][boxColumnOffset + j] == num) {
                     return false;
                }
            }
        }
        return true;
    }

    public void showSolution() {
        for (int row = 0; row < Constants.BOARD_SIZE; row++) {
            if (row % 3 == 0) System.out.println();
            for (int col = 0; col < Constants.BOARD_SIZE; col++) {
                if (col % 3 == 0) System.out.print(" ");
                System.out.print(this.table[row][col] + "  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] sudokuTable = {
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };
        Sudoku sudoku = new Sudoku(sudokuTable);
        sudoku.solve();
    }
}
