package questions.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LuckyNumberInAMatrix {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int M = matrix.length;
        int N = matrix[0].length;
        int rLargestMin = Integer.MIN_VALUE;

        for (int i = 0; i < M; i++) {
            int rMin = Arrays.stream(matrix[i]).min().getAsInt();
            rLargestMin = Math.max(rLargestMin, rMin);
        }

        int cSmallestMax = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            int cMax = Integer.MIN_VALUE;
            for (int j = 0; j < M; j++) {
                cMax = Math.max(cMax, matrix[j][i]);
            }
            cSmallestMax = Math.min(cSmallestMax, cMax);
        }


        if (rLargestMin == cSmallestMax) {
            return Collections.singletonList(rLargestMin);
        } else {
            return new ArrayList<>();
        }
    }
}
