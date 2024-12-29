package questions.leetcode;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] map = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            map[magazine.charAt(i) - 'a'] ++;
        }

        for (char c : ransomNote.toCharArray()) {
            int value = map[c - 'a'];

            if (value <= 0) {
                return false;
            }
            map[c - 'a']--;

        }
        return true;
    }
}
