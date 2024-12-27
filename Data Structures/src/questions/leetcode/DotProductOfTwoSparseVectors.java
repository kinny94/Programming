package questions.leetcode;

import java.util.HashMap;
import java.util.Map;

public class DotProductOfTwoSparseVectors {
    private Map<Integer, Integer> map;

    DotProductOfTwoSparseVectors(int[] nums) {
        map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != 0) {
                map.put(i, nums[i]);
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(DotProductOfTwoSparseVectors vec) {
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int i = entry.getKey();
            int v = entry.getValue();
            if (vec.map.containsKey(i)) {
                sum += v * vec.map.get(i);
            }
        }
        return sum;
    }
}
