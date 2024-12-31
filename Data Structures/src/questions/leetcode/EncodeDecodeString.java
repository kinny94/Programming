package questions.leetcode;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecodeString {

    public static String lengthToBytes(String x) {
        int length = x.length();
        StringBuilder bytes = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            bytes.append((char) (length >> (i * 8)));
        }

        return bytes.reverse().toString();
    }

    public static int bytesToLength(String bytesString) {
        int result = 0;

        for (char c : bytesString.toCharArray()) {
            result = result * 256 + c;
        }

        return result;
    }

    public static String encode(List<String> strings) {
        StringBuilder encodedString = new StringBuilder();

        for (String x : strings) {
            encodedString.append(lengthToBytes(x)).append(x);
        }

        return encodedString.toString();
    }

    public static List<String> decode(String str) {
        int i = 0;
        List<String> decodedString = new ArrayList<>();

        while (i < str.length()) {
            int length = bytesToLength(str.substring(i, i + 4));
            i += 4;
            decodedString.add(str.substring(i, i + length));
            i += length;
        }

        return decodedString;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
