package questions.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        if(nums == null || nums.length == 0){
            return result;
        }
        int s = 0;
        for(int i =0; i<nums.length; i++){
            s = result.size();
            for(int j = 0;j<s;j++){
                List<Integer> set = new ArrayList<>(result.get(j));
                set.add(nums[i]);
                result.add(set);
            }
        }
        return result;
    }
}
