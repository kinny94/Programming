package questions.leetcode;

import java.util.*;

public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < 10) {
            return new ArrayList<>();
        }

        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 1);
        map.put('C', 2);
        map.put('G', 3);
        map.put('T', 4);

        int[] numbers = new int[s.length()];
        for (int i=0; i<s.length(); i++) {
            numbers[i] = map.get(s.charAt(i));
        }

        Set<Integer> hashValues = new HashSet<>();
        Set<String> output = new HashSet<>();
        int hashValue = 0;
        int baseValue = 4;

        for (int i=0; i<s.length() - 10 + 1; i++) {
            if (i == 0) {
                for (int j = 0; j<10; j++) {
                    hashValue += numbers[j] * (int) Math.pow(baseValue, 10-j-1);
                }
            } else {
                int previousHash = hashValue;
                hashValue = ((previousHash - numbers[i-1] * (int) Math.pow(baseValue, 10-1)) * baseValue) + numbers[i+10-1];
            }

            if (hashValues.contains(hashValue)) {
                output.add(s.substring(i, i + 10));
            }

            hashValues.add(hashValue);
        }
        List<String> mainList = new ArrayList<String>();
        mainList.addAll(output);
        return mainList;

    }
}