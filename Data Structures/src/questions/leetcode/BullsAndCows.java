package questions.leetcode;

import java.util.HashMap;
import java.util.Map;

public class BullsAndCows {
    public String getHint(String secret, String guess) {
        Map<Character, Integer> map = new HashMap<>();
        int bulls = 0;
        int cows = 0;

        for (int i=0; i<secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);

            if (s == g) {
                bulls++;
            } else {
                if (map.getOrDefault(s, 0) < 0) {
                    cows++;
                }

                if (map.getOrDefault(g, 0) > 0) {
                    cows++;
                }

                map.put(s, map.getOrDefault(s, 0) + 1);
                map.put(g, map.getOrDefault(g, 0) - 1);
            }
        }

        return bulls + "A" + cows + "B";
    }
}
