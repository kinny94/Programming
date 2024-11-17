package algorithms.datacompression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RunLengthEncoding {

    public String encoding(String text) {

        // concat operation is O(1) with SB, O(N) with String
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            int runLength = 1; // consider there are no adjacent letter
            while (i+1 < text.length() && text.charAt(i) == text.charAt(i+1)) {
                runLength++;
                i++;
            }
            stringBuilder.append(runLength).append(text.charAt(i));
        }
        return stringBuilder.toString();
    }

    public String decoding(String text) {
        StringBuilder stringBuilder = new StringBuilder();
        Pattern pattern = Pattern.compile("[0-9]+|[a-zA-Z]");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            int num = Integer.parseInt(matcher.group());
            matcher.find();
            while(num-- != 0) {
                stringBuilder.append(matcher.group());
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        RunLengthEncoding runLengthEncoding = new RunLengthEncoding();
        String encodedString = runLengthEncoding.encoding("AAABCEEDDD");
        System.out.println(encodedString);
        System.out.println(runLengthEncoding.decoding(encodedString));
    }
}
