import java.util.HashMap;
import java.util.Map;

// write an algo to find all pairs of two integers in an unsorted array that  sum to given S

// Use DP - memoization
class TwoSum {

  private int S;
  private Map<Integer, Integer> map;
  private int[] nums;

  TwoSum(int[] nums, int S) {
    this.S = S;
    this.nums = nums;
    this.map = new HashMap<>();
  }

  public void solve() {
    for (int i=0; i<nums.length; ++i) {
      int remainder = S - nums[i];

      if (map.containsValue(remainder)) {
        System.out.println("Solution: " + nums[i] + " " + remainder+ " = " + S);
      }

      map.put(i, nums[i]);
    }
  }

  public static void main(String[] args) {
    int[] nums = {3, 5, 2, -4, 8, 11};
    int S = 7;

    TwoSum pairs = new TwoSum(nums, S);
    pairs.solve();
  }

}