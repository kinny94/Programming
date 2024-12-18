package questions.leetcode;

import java.util.ArrayList;
import java.util.List;

public class KSumSubset{
    public static List<List<Integer>> getKSumSubsets(int[] nums, int k) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        if(nums == null || nums.length == 0){
            return result;
        }

        int s = 0;
        for (int i=0; i<nums.length; i++) {
            s = result.size();
            for (int j=0; j<s; j++) {
                List<Integer> curr = new ArrayList<>(result.get(j));
                curr.add(nums[i]);
                result.add(curr);
            }
        }

        List<List<Integer>> filteredResult = new ArrayList<>();
        for (List<Integer> subset : result) {
            int sum = 0;
            for (int num : subset) {
                sum += num;
            }
            if (sum == k) {
                filteredResult.add(subset);
            }
        }
        result = filteredResult;
        return filteredResult;
    }
}