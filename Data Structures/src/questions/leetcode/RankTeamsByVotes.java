package questions.leetcode;

import java.util.Arrays;

public class RankTeamsByVotes {
    public String rankTeams(String[] votes) {
        int[][] counts = new int[26][27];
        for (int i=0; i<26; i++) {
            counts[i][26] = 'A' + i;
        }

        for(String vote: votes) {
            for (int i=0; i<vote.length(); i++) {
                char c = vote.charAt(i);
                --counts[c - 'A'][i];
            }
        }

        Arrays.sort(counts, (a, b) -> {
            for (int i=0; i<26; i++) {
                if (a[i] != b[i]) {
                    return Integer.compare(a[i], b[i]);
                }
            }
            return Integer.compare(a[26], b[26]);
        });

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<votes[0].length(); i++) {
            char c = (char) counts[i][26];
            sb.append(c);
        }

        return sb.toString();
    }
}
