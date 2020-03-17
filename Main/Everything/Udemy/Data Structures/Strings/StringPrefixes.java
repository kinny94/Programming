import java.util.ArrayList;
import java.util.List;

class StringPrefixes {

    public List<String> getPrefixes(String text) {

        int length = text.length();
        List<String> prefixList = new ArrayList<>();

        for (int i=1; i<length+1; i++) {
            prefixList.add(text.substring(0, i));
        }

        return prefixList;
    }

    public static void main(String[] args) {
        StringPrefixes sp = new StringPrefixes();
        System.out.println(sp.getPrefixes("hello"));
    }
}