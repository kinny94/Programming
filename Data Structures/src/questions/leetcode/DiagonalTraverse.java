package questions.leetcode;

import java.util.ArrayList;
import java.util.List;

public class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        List<Integer> result = new ArrayList<>();

        int currRow = 0;
        int currCol = 0;

        boolean goingUp = true;

        while (result.size() != rows * cols) {
            if (goingUp) {
                // keep going up and to the right
                while (currRow >=0 && currCol < cols) {
                    result.add(mat[currRow][currCol]);
                    currRow--;
                    currCol++;
                }
                // while loop ends - outside the bounds on the upper right side
                // check if we are outside both row and col
                if (currCol == cols) {
                    // bring down 2 levels coz last one was already covered while goin up
                    currCol--;
                    currRow += 2;
                } else {
                    // cols are still there on the right.. only go down
                    currRow++;
                }
                // now complete going up
                goingUp = false;
            } else {
                while (currRow < rows && currCol >= 0) {
                    result.add(mat[currRow][currCol]);
                    currRow++;
                    currCol--;
                }

                if (currRow == rows) {
                    currCol += 2;
                    currRow--;
                } else {
                    currCol++;
                }

                goingUp = true;
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
