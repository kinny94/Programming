package questions.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        int row = 0;
        int col = -1;
        int direction = 1;

        while(rows > 0 && cols > 0) {
            for (int i=0; i<cols; i++) {
                col = col + direction;
                result.add(matrix[row][col]);
            }
            rows--;

            for (int i=0; i<rows; i++) {
                row = row + direction;
                result.add(matrix[row][col]);
            }
            cols--;
            direction = direction * -1;
        }
        return result;
    }
}
