package questions.leetcode;

class WordSearch {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (solve(i, j, word, 0, board)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean solve(int row, int col, String word, int index, char[][] board) {
        if (index == word.length()) {
            return true;
        }

        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || word.charAt(index) != board[row][col]) {
            return false;
        }

        boolean result = false;
        char temp = board[row][col];
        board[row][col] = '*';

        int[][] offsets = {
                {1, 0}, {0, 1}, {-1, 0}, {0, -1}
        };
        for (int[] offset: offsets) {
            int newRow = offset[0];
            int newCol = offset[1];
            result = solve(row + newRow, col + newCol, word, index + 1, board);

            if (result) {
                break;
            }
        }
        board[row][col] = temp;
        return result;
    }
}