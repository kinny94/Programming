package questions.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CountTripletsThatCanFormTwoArraysOfEqualXOR {
    public int countTriplets(int[] arr) {
        int count = 0;
        int prefix = 0;

        Map<Integer, Integer> countMap = new HashMap<>();
        Map<Integer, Integer> totalMap = new HashMap<>();
        countMap.put(0, 1);

        for (int i = 0; i < arr.length; i++) {
            prefix ^= arr[i];
            count += countMap.getOrDefault(prefix, 0) * i - totalMap.getOrDefault(prefix, 0);
            countMap.put(prefix, countMap.getOrDefault(prefix, 0) + 1);
            totalMap.put(prefix, totalMap.getOrDefault(prefix, 0) + (i + 1));
        }

        return count;
    }
}
