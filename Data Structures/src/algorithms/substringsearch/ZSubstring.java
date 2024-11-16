package algorithms.substringsearch;

public class ZSubstring {

    private int[] zTable;

    public boolean search(String text, String pattern) {
        boolean found = false;
        this.zTable = new int[text.length() + pattern.length()];
        constructTable(text, pattern);

        for (int i=0; i<zTable.length; i++) {
            if (zTable[i] >= pattern.length()) {
                System.out.println("Match found at index " + (i - pattern.length())); // because of concatenation
                found = true;
            }
        }
        return found;
    }

    private void constructTable(String text, String pattern) {
        String patternText = pattern + text;
        int leftPointer = 0;
        int rightPointer = 0;
        int concatenatedLength = patternText.length();

        // consider the letters of the concatenated string one by one
        // we don't care about the first letter
        for (int i=1; i<concatenatedLength; i++) {
            // we have to use the naive z calculate case 1
            if (i > rightPointer) {
                int matchCounter = 0;
                while (i + matchCounter < concatenatedLength && patternText.charAt(matchCounter) == patternText.charAt(i + matchCounter)) {
                    matchCounter++;
                }
                zTable[i] = matchCounter;
                // update the left and right indexes
                // we update the z box index if the match counter is greater than 0
                leftPointer = i;
                rightPointer = i + matchCounter;
            } else {
                // we know that k is within z box
                // we will use the existing value from the z box
                int pairIndex = i - leftPointer;

                // CASE 2: We can copy the value
                if (zTable[pairIndex] < rightPointer - i + 1) {
                    zTable[i] = zTable[pairIndex];
                } else {
                    // use the naive approach again
                    // this is the first item we have to consider outsize the z box
                    int k = rightPointer + 1;
                    while (k<concatenatedLength && patternText.charAt(k) == patternText.charAt(k - i)) {
                        k++;
                    }
                    zTable[i] = k - i;
                    // we have found another z box
                    leftPointer = i;
                    rightPointer = k - 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        ZSubstring zSubstring = new ZSubstring();
        System.out.println(zSubstring.search("This is a text", "text"));
        System.out.println(zSubstring.search("ttttta", "tta"));
        System.out.println(zSubstring.search("ttttta", "tat"));
        System.out.println(zSubstring.search("aacaaccaac!", "aaab"));
        System.out.println(zSubstring.search("aacaaccaaceeeaac!", "aac"));

    }
}
