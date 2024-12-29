package questions.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String a, String b) {
        List<Integer> ans = new ArrayList<>();
        if (b.length() > a.length()) {
            return ans;
        }

        Map<Character, Integer> hashA = new HashMap<>();
        Map<Character, Integer> hashB = new HashMap<>();

        for (int i=0; i<b.length(); i++) {
            if (!hashB.containsKey(b.charAt(i))) {
                hashB.put(b.charAt(i), 1);
            } else {
                hashB.put(b.charAt(i), hashB.get(b.charAt(i)) + 1);
            }
        }

        int windowEnd = 0;

        while(windowEnd < a.length()) {
            if (!hashA.containsKey(a.charAt(windowEnd))) {
                hashA.put(a.charAt(windowEnd), 1);
            } else{
                hashA.put(a.charAt(windowEnd), hashA.get(a.charAt(windowEnd)) + 1);
            }

            int windowStart = windowEnd - b.length();

            if (windowEnd >= b.length()) {
                if (hashA.get(a.charAt(windowStart)) == 1) {
                    hashA.remove(a.charAt(windowStart));
                } else {
                    if (!hashA.containsKey(a.charAt(windowStart))) {
                        hashA.put(a.charAt(windowStart), 1);
                    } else {
                        hashA.put(a.charAt(windowStart), hashA.get(a.charAt(windowStart)) - 1);
                    }
                }
            }
            windowEnd++;

            if (hashA.equals(hashB)) {
                ans.add(windowEnd - b.length());
            }
        }
        return ans;
    }
}
