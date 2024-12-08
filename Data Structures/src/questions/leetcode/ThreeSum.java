package questions.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i=0; i<nums.length - 2; i++) {

            // Skip duplicates for the first element
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int low = i + 1;
            int high = nums.length - 1;

            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (sum == 0) {
                    list.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    // Skip duplicates for the second element
                    while (low < high && nums[low] == nums[low + 1]) {
                        low++;
                    }
                    // Skip duplicates for the third element
                    while (low < high && nums[high] == nums[high - 1]) {
                        high--;
                    }

                    // Move both pointers
                    low++;
                    high--;
                }
                else if (sum < 0) {
                    low++;
                } else {
                    high--;
                }
            }
        }
        return list;
    }
}
