package questions.leetcode;

import java.util.HashMap;
import java.util.Map;

public class NumberOfWonderfulSubstrings {
    public long wonderfulSubstrings(String word) {
        Map<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1);

        int mask = 0;
        long res = 0;

        for (char c: word.toCharArray()) {
            int bit = c - 'a';
            mask ^= (1<<bit);

            if (freq.containsKey(mask)) {
                res += freq.get(mask);
                freq.put(mask, freq.get(mask) + 1);
            } else{
                freq.put(mask, 1);
            }

            for (int odd_c = 0; odd_c < 10; ++odd_c)
            {
                int toggled_mask = mask ^ (1 << odd_c);

                if (freq.containsKey(toggled_mask)) {
                    res += freq.get(toggled_mask);
                }
            }
        }
        return res;
    }
}
