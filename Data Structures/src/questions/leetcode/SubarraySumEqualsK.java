package questions.leetcode;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {

        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum  = 0;
        for (int num: nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
        // Sliding window not valid for neagtive
        // int windowStart = 0;
        // int currentSum = 0;
        // int count = 0;

        // for (int i=0; i<nums.length; i++) {
        //     currentSum += nums[i];
        //     if (currentSum == k) {
        //         // increment count... subtract element at windowStart to consider next
        //         count++;
        //         currentSum -= nums[windowStart];
        //         windowStart++;
        //     } else if (currentSum < k) {
        //         // increase windowSize - take in next element
        //         continue;
        //     } else {
        //         int temp = windowStart;
        //         int tempSum = currentSum - nums[temp];
        //         while(temp != i) {
        //             if (tempSum < k) {
        //                 break;
        //             }
        //             if (tempSum == k) {
        //                 count++;
        //                 break;
        //             }
        //             temp++;
        //         }
        //     }
        // }
        // return count;
    }
}
