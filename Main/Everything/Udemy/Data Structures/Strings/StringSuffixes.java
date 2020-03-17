import java.util.ArrayList;
import java.util.List;

class StringSuffixes {

    public List<String> getSuffixes(String text) {
        int lengthOfText = text.length();
        List<String> suffixes = new ArrayList<>();

        for (int i=0; i<lengthOfText; ++i) {
            suffixes.add(text.substring(i, lengthOfText)); //O(1); StringBuilder takes O(N)
        }

        return suffixes;
    }
    public static void main(String[] args) {
        StringSuffixes suff = new StringSuffixes();
        System.out.println(suff.getSuffixes("hello"));
    }
}