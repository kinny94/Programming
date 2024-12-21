package questions.leetcode;

import java.util.Arrays;

public class SetMatrixZeros {
    public void setZeroes(int[][] matrix) {
        boolean fRow = false;
        boolean fCol = false;

        for (int i=0; i<matrix.length; i++) {
            if (matrix[i][0] == 0) {
                fCol = true;
            }
        }

        for (int i=0; i<matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                fRow = true;
            }
        }

        for (int i=1; i<matrix.length; i++) {
            for (int j=1; j<matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i=1; i<matrix.length; i++) {
            if (matrix[i][0] == 0) {
                Arrays.fill(matrix[i], 0);
            }
        }

        for (int i=1; i<matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                for (int j=1; j<matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        if (fCol) {
            for (int i=0; i<matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

        if (fRow) {
            Arrays.fill(matrix[0], 0);
        }
    }
}
}
