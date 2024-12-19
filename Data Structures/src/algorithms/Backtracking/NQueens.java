package algorithms.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

    private int[][] chessTable;
    private int numOfQueens;
    private List<List<String>> solutions; // To store all solutions

    public NQueens(int n) {
        this.numOfQueens = n;
        this.chessTable = new int[n][n];
        this.solutions = new ArrayList<>();
    }

    public List<List<String>> solve() {
        setQueens(0);
        return solutions;
    }

    private boolean setQueens(int colIndex) {
        if (colIndex == numOfQueens) {
            saveSolution(); // Save the current solution
            return true; // Continue searching for other solutions
        }

        boolean foundSolution = false;

        for (int rowIndex = 0; rowIndex < numOfQueens; rowIndex++) {
            if (isPlaceValid(rowIndex, colIndex)) {
                chessTable[rowIndex][colIndex] = 1;
                foundSolution = setQueens(colIndex + 1) || foundSolution;
                chessTable[rowIndex][colIndex] = 0; // Backtrack
            }
        }

        return foundSolution;
    }

    private boolean isPlaceValid(int rowIndex, int colIndex) {
        for (int i = 0; i < colIndex; i++) {
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

    private void saveSolution() {
        List<String> currentSolution = new ArrayList<>();
        for (int i = 0; i < numOfQueens; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < numOfQueens; j++) {
                if (chessTable[i][j] == 1) {
                    row.append("Q");
                } else {
                    row.append(".");
                }
            }
            currentSolution.add(row.toString());
        }
        solutions.add(currentSolution);
    }

    public static void main(String[] args) {
        System.out.println("Solutions for N = 4:");
        NQueens nQueens4 = new NQueens(4);
        List<List<String>> result = nQueens4.solve();
        for (List<String> solution : result) {
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}