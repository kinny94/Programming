package questions.leetcode;

public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        transpose(matrix, n);
        reverse(matrix, n);
    }

    // only for square matrices
    private void transpose(int[][] matrix, int n) {
        for (int i=0; i<n; i++) {
            for (int j=i + 1; j<n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    private void reverse(int[][] matrix, int n) {
        for (int i=0; i<n; i++) {
            for (int j=0;j<n/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }
    }
}
