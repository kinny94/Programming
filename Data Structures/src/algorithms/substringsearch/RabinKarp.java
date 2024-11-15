package algorithms.substringsearch;

public class RabinKarp {

    private int prime = 31;

    public int search(String text, String pattern) {

        int textLength = text.length();
        int patternLength = pattern.length();

        long textHash = createHash(text, patternLength);
        long patternHash = createHash(pattern, patternLength);

        for (int i = 0; i <= textLength - pattern.length(); i++) {
            if (textHash == patternHash && checkEqual(text, i, i+patternLength-1, pattern, 0, patternLength-1)) {
                return i;
            }
            if (i < textLength - patternLength) {
                textHash = recalculateHash(text, i, textHash, patternLength);
            }
        }
        return -1;
    }

    private long recalculateHash(String text, int oldIndex, long oldHash, int patternLength) {
        int newIndex = oldIndex + patternLength;
        long newHash = oldHash - text.charAt(oldIndex);
        newHash /= prime;
        newHash += (long) (text.charAt(newIndex) * Math.pow(prime, patternLength - 1));
        return newHash;
    }

    private boolean checkEqual(String text, int start1, int end1, String pattern, int start2, int end2) {
        if (end1 - start1 != end2 - start2) {
            return false;
        }

        while (start1 <= end1 && start2 <= end2) {
            if (text.charAt(start1) != pattern.charAt(start2)) {
                return false;
            }
            start1++;
            start2++;
        }
        return true;
    }

    private long createHash(String text, int length) {
        long hashValue = 0;
        for (int i = 0; i < length; i++) {
            hashValue += (long) (text.charAt(i) * Math.pow(prime, i));
        }
        return hashValue;
    }


    public static void main(String[] args) {
        RabinKarp rabinKarp = new RabinKarp();
        System.out.println(rabinKarp.search("This is a text", "text"));
        System.out.println(rabinKarp.search("ttttta", "tta"));
        System.out.println(rabinKarp.search("ttttta", "tat"));
    }
}
