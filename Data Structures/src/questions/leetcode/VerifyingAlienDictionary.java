package questions.leetcode;

import java.util.HashMap;
import java.util.Map;

public class VerifyingAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> ranking = new HashMap<>();
        for (int i=0; i<order.length(); i++) {
            ranking.put(order.charAt(i), i);
        }

        for (int i=0; i<words.length - 1; i++) {
            String currentWord = words[i];
            String nextWord = words[i + 1];
            for (int j=0; j<currentWord.length(); j++) {

                if (j >= nextWord.length()) {
                    return false;
                }

                if (currentWord.charAt(j) != nextWord.charAt(j)) {
                    if (ranking.get(currentWord.charAt(j)) > ranking.get(nextWord.charAt(j))) {
                        return false;
                    } else{
                        break;
                    }
                }
            }
        }

        return true;
    }
}
