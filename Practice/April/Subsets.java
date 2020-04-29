import java.util.ArrayList;
import java.util.List;

class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> results = new ArrayList<>();
        createSubsets(results, 0, new ArrayList<>(), nums);
        return results;
    }

    public void createSubsets(List<List<Integer>> results, int index, List<Integer> currentList, int[] nums) {
        if (index == nums.length) {
            results.add(new ArrayList<>(currentList));
        }

        for (int i=index; i<=nums.length; i++) {
            currentList.add(nums[i]);
            createSubsets(results, i + 1, currentList, nums);
            currentList.remove(currentList.size() - 1);
        }
    }
}