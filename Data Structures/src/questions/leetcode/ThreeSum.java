package questions.leetcode;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();

        if (nums.length < 3) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        int low; int high;

        for (int i=0; i<nums.length; i++) {
            low = i + 1;
            high = nums.length - 1;

            while (low < high) {
                if (nums[i] + nums[low] + nums[high] == 0) {
                    result.add(new ArrayList<>(Arrays.asList(nums[i], nums[low], nums[high])));

                    while(low < high && nums[low] == nums[low + 1]) {
                        low++;
                    }

                    while (low < high && nums[high] == nums[high - 1]) {
                        high--;
                    }

                    low++;
                    high--;
                } else if (nums[i] + nums[low] + nums[high] < 0) {
                    low++;
                } else {
                    high--;
                }
            }
        }
        return new ArrayList<>(result);
    }
}
