package questions.leetcode;

import java.util.HashMap;
import java.util.Map;

class TwoSumIII {

    private Map<Integer, Integer> nums;

    public TwoSumIII() {
        nums = new HashMap<>();
    }

    public void add(int number) {
        nums.put(number, nums.getOrDefault(number, 0 ) + 1);
    }

    public boolean find(int value) {
        for (int num: nums.keySet()) {
            int complement = value - num;
            if (nums.containsKey(complement)) {
                if (complement != num || nums.get(num) > 1) {
                    return true;
                }
            }
        }
        return false;

    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
