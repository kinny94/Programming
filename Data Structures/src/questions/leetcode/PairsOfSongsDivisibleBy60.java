package questions.leetcode;

public class PairsOfSongsDivisibleBy60 {
    public int numPairsDivisibleBy60(int[] time) {
        int[] remainders = new int[60];
        int count= 0;

        for (int i: time) {
            int remainder = i % 60;

            if (remainder == 0) {
                count += remainders[0];
            } else {
                count += remainders[60 - remainder];
            }

            remainders[remainder]++;
        }
        return count;
    }
}
