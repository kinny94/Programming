package algorithms.substringsearch;

public class BruteForceSearch {

    public int search(String text, String pat) {
        int lengthOfText = text.length();
        int lengthOfPat = pat.length();

        for (int i = 0; i <= lengthOfText - lengthOfPat; i++) {
            int j;
            for (j = 0; j < lengthOfPat; j++) {
                if (text.charAt(i + j) != pat.charAt(j)) {
                    break;
                }
            }
            if (j == lengthOfPat) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BruteForceSearch bfs = new BruteForceSearch();
        System.out.println(bfs.search("This is a text", "text"));
        System.out.println(bfs.search("ttttta", "tta"));
        System.out.println(bfs.search("ttttta", "tat"));
    }
}
