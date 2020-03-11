import java.util.HashMap;
import java.util.Map;

class BoyerMoore {
    private String text;
    private String pattern;
    private Map<Character, Integer> misMatchShiftTable;

    BoyerMoore(String text, String pattern) {
        this.text = text;
        this.pattern = pattern;
        this.misMatchShiftTable = new HashMap<>();
    }

    public void createBadMatchTable() { // create a mis match table
        int lengthOfOPattern = this.pattern.length();
        for (int index=0; index<lengthOfOPattern; index++)  {
            char actualCharacter = this.pattern.charAt(index);
            int maxShift = Math.max(1, lengthOfOPattern - index - 1);
            this.misMatchShiftTable.put(actualCharacter, maxShift);
        }
    }

    public int search() {

        this.createBadMatchTable(); 

        int lengthOfPattern = this.pattern.length();
        int lengthOfText = this.text.length();
        int numOfSkips;

        for (int i=0; i<=lengthOfText - lengthOfPattern; i+=numOfSkips) {
            numOfSkips = 0;
            for (int j=lengthOfPattern-1; j>=0; j--) {
                if (pattern.charAt(j) != text.charAt(j+i)) {
                    if (this.misMatchShiftTable.get(text.charAt(i+j)) != null) {
                        numOfSkips = this.misMatchShiftTable.get(text.charAt(i+j));
                        break;
                    } else {
                        numOfSkips = lengthOfPattern;
                        break;
                    }
                }
            }

            if (numOfSkips == 0) {
                return i;
            }
        }

        return  lengthOfText;
    }

    public static void main(String[] args) {
        String text = "My name is Arjun Dass";
        String pattern = "name";
        String pattern2 = "is";
        String pattern3 = "no";
        String pattern4 = "Ar";

        BoyerMoore bm = new BoyerMoore(text, pattern);
        BoyerMoore bm2 = new BoyerMoore(text, pattern2);
        BoyerMoore bm3 = new BoyerMoore(text, pattern3);
        BoyerMoore bm4 = new BoyerMoore(text, pattern4);

        System.out.println(bm.search());
        System.out.println(bm2.search());
        System.out.println(bm3.search());
        System.out.println(bm4.search());
    }
}