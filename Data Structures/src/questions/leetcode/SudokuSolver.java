package questions.leetcode;

public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        findSolution(0, 0,  board);
    }

    private boolean findSolution(int rowIndex, int colIndex, char[][] board) {
        if (rowIndex == board.length) {
            colIndex++;
            rowIndex = 0;
            if (colIndex == board.length) {
                return true;
            }
        }

        if (board[rowIndex][colIndex] != '.') {
            return findSolution(rowIndex + 1, colIndex, board);
        }

        for (int i=1; i<=9; i++) {
            if (isValid(rowIndex, colIndex, i, board)) {
                board[rowIndex][colIndex] = (char) (i + '0');
                if (findSolution(rowIndex + 1, colIndex, board)) {
                    return true;
                }
                board[rowIndex][colIndex] = '.';
            }
        }

        return false;
    }

    private boolean isValid(int rowIndex, int colIndex,  int value, char[][] board) {
        for (int i=0; i<board.length; i++) {
            if (board[i][colIndex] == (char) (value + '0')) {
                return false;
            }
        }

        for (int i=0; i<board.length; i++) {
            if (board[rowIndex][i] == (char) (value + '0')) {
                return false;
            }
        }

        int rowOffset = (rowIndex / 3) * 3;
        int colOffset = (colIndex / 3) * 3;

        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                if (board[i + rowOffset][j + colOffset] == (char) (value + '0')) {
                    return false;
                }
            }
        }
        return true;
    }
}
