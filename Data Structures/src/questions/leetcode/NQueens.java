package questions.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    int[][] chessTable;
    int numOfQueens;
    List<List<String>> solutions;

    public List<List<String>> solveNQueens(int n) {
        this.numOfQueens = n;
        this.chessTable = new int[n][n];
        solutions = new ArrayList<>();
        solve(0);
        return solutions;
    }

    public boolean solve(int colIndex) {
        if (colIndex == numOfQueens) {
            saveSolution();
            return true;
        }

        boolean foundSolution = false;
        for (int rowIndex = 0; rowIndex < numOfQueens; rowIndex++) {
            if (isPlaceValid(rowIndex, colIndex)) {
                chessTable[rowIndex][colIndex] = 1;
                foundSolution = solve(colIndex + 1) || foundSolution;
                chessTable[rowIndex][colIndex] = 0;
            }
        }
        return foundSolution;
    }

    public boolean isPlaceValid(int rowIndex, int colIndex) {
        for (int i=0; i<colIndex; i++) {
            if (chessTable[rowIndex][i] == 1) {
                return false;
            }
        }

        // Check the diagonals on the left
        for (int i = 0; i <= colIndex; i++) {
            // Upper-left diagonal
            if (rowIndex - i >= 0 && colIndex - i >= 0 && chessTable[rowIndex - i][colIndex - i] == 1) {
                return false;
            }
            // Lower-left diagonal
            if (rowIndex + i < chessTable.length && colIndex - i >= 0 && chessTable[rowIndex + i][colIndex - i] == 1) {
                return false;
            }
        }
        return true;
    }

    public void saveSolution() {
        List<String> currentSolution = new ArrayList<>();
        for (int i=0; i<numOfQueens; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j=0; j<numOfQueens; j++) {
                if (chessTable[i][j] == 1) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            currentSolution.add(sb.toString());
        }
        solutions.add(currentSolution);
    }
}
