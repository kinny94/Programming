import java.util.ArrayList;
import java.util.List;

import sun.font.CreatedFontTracker;

class Permuations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return results;
        }

        createPermutations(results,  new ArrayList<>(), 0, nums);
        return results;
    }

    public void createPermutations(List<List<Integer>> results, List<Integer> currentList, int index, int[] nums) {

        if (currentList.size() == nums.length) {
            results.add(new ArrayList<>(currentList));
            return;
        }

        for (int i=0; i<nums.length; i++) {
            if (!currentList.contains(nums[i])) {
                currentList.add(nums[i]);
                createPermutations(results, currentList, i, nums);
                currentList.remove(currentList.size() - 1);
            }
        }
    }
}