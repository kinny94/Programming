package questions.leetcode;

import java.util.Arrays;

public class FindCenterOfTheGraph {
    public int findCenter(int[][] edges) {
        int[] first = edges[0];
        int[] second = edges[1];

        if (Arrays.stream(second).anyMatch(x -> x == first[0])) {
            return first[0];
        } else {
            return first[1];
        }
    }
}
