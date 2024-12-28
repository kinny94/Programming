package questions.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesignTicTacToe {
    List<Integer> rows;
    List<Integer> cols;
    int diagonal;
    int antiDiagonal;

    public DesignTicTacToe(int n) {
        rows = new ArrayList<>(Collections.nCopies(n, 0));
        cols = new ArrayList<>(Collections.nCopies(n, 0));
        diagonal = 0;
        antiDiagonal = 0;
    }

    public int move(int row, int col, int player) {
        int currentPlayer = player == 1 ? 1 : -1;
        int n = rows.size();

        rows.set(row, rows.get(row) + currentPlayer);
        cols.set(col, cols.get(col) + currentPlayer);

        if (row == col) {
            diagonal += currentPlayer;
        }

        if (col == (n - row - 1)) {
            antiDiagonal += currentPlayer;
        }

        if (Math.abs(rows.get(row)) == n || Math.abs(cols.get(col)) == n || Math.abs(diagonal) == n || Math.abs(antiDiagonal) == n) {
            return player;
        }

        return 0;

    }
}
