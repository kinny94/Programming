package questions.leetcode;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int count = 0;

        for (char c: map.keySet()) {
            if (map.get(c) % 2 != 0) {
                count += 1;
            }
        }

        return count <= 1 ?  true : false;
    }
}
