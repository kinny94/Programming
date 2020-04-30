import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> results = new ArrayList<>();
        
        if (candidates == null || candidates.length == 0) {
            return results;
        }

        Arrays.sort(candidates);
        createCombinations(results, new ArrayList<>(), 0, candidates, target);
        return results;
    }

    private void createCombinations(List<List<Integer>> results, List<Integer> currentList, int index, int[] candidates, int target) {
        
        if (target == 0) {
            results.add(new ArrayList<>(currentList));
        }

        for (int i=index; i<candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }

            currentList.add(candidates[i]);
            createCombinations(results, currentList, i, candidates, target - candidates[i]);
            currentList.remove(currentList.size() - 1);
        }
    }
}