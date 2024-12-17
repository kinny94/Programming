package questions.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        permute(nums, 0, results);
        return results;
    }

    private void permute(int[] nums, int index, List<List<Integer>> result) {
        if (index == nums.length) {
            List<Integer> list = new ArrayList<>();
            for(int n : nums){
                list.add(n);
            }
            result.add(list);
            return;
        }

        for (int i = index; i<nums.length; i++) {
            swap(nums, index, i);
            permute(nums, index + 1, result);
            swap(nums, i, index);
        }
    }

    private void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
