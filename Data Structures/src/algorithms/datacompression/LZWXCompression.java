package algorithms.datacompression;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LZWXCompression {

    public static List<Integer> compress(String uncompressedString) {
        int dictionarySize = 256;
        Map<String, Integer> dictionary = new HashMap<>();

        for (int i = 0; i < dictionarySize; i++) {
            dictionary.put("" + (char) i, i);
        }
        String tempString = "";
        List<Integer> result = new ArrayList<>();
        for (char c: uncompressedString.toCharArray()) {
            String tempString2 = tempString + c;
            if (dictionary.containsKey(tempString2)) {
                tempString = tempString2;
            } else {
                result.add(dictionary.get(tempString));
                dictionary.put(tempString, dictionarySize++);
                tempString = ""+c;
            }
        }

        if (!tempString.equals("")) {
            result.add(dictionary.get(tempString));
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> compressed = compress("CARRARCARCAR");
        System.out.println(compressed);
    }
}
