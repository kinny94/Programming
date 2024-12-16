package questions.leetcode;

import java.util.*;

public class RandomPickIndex {
    Map<Integer, List<Integer>> freqMap = new HashMap<>();
    public RandomPickIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (!freqMap.containsKey(nums[i])) {
                freqMap.put(nums[i], new ArrayList<>());
            }
            freqMap.get(nums[i]).add(i);
        }
    }

    public int pick(int target) {
        if (freqMap.containsKey(target)){
            Random rand = new Random();
            List<Integer> pick = freqMap.get(target);
            int randomIndex = rand.nextInt(pick.size());
            return pick.get(randomIndex);
        }
        return -1;

    }
}
