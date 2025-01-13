package questions.leetcode;

public class KthSmallestElementInASortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n - 1][n-1];

        while(low < high) {
            int mid = low + (high - low)/2;
            int count = countLessOrEqual(matrix, mid);

            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public int countLessOrEqual(int[][] matrix, int target) {
        int n = matrix.length;
        int count = 0;
        int row = n - 1;

        for (int col=0; col < n; col++) {
            while (row >= 0 && matrix[row][col] > target) {
                row--;
            }
            count += row + 1;
        }
        return count;
    }
}
