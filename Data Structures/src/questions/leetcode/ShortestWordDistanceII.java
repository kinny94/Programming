package questions.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ShortestWordDistanceII {

    private Map<String, List<Integer>> wordIndices;

    public ShortestWordDistanceII(String[] wordsDict) {
        wordIndices = new HashMap<>();
        for (int i=0; i<wordsDict.length; i++) {
            String word = wordsDict[i];
            wordIndices.computeIfAbsent(word, k -> new ArrayList<>()).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> indices1 = wordIndices.get(word1);
        List<Integer> indices2 = wordIndices.get(word2);
        int i=0;
        int j=0;
        int minDistance = Integer.MAX_VALUE;

        while (i < indices1.size() && j < indices2.size()) {
            minDistance = Math.min(minDistance, Math.abs(indices1.get(i) - indices2.get(j)));
            if (indices1.get(i) < indices2.get(j)) {
                i++;
            } else{
                j++;
            }
        }
        return minDistance;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */
