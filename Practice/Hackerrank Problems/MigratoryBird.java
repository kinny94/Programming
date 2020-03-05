import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the migratoryBirds function below.
    static int migratoryBirds(List<Integer> arr) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i=0; i<arr.size(); i++) {
            if (map.containsKey(arr.get(i))) {
                map.put(arr.get(i), map.get(arr.get(i)) + 1);
            } else {
                map.put(arr.get(i), 1);
            }
        }

        int OccasionalBirdValue = Integer.MIN_VALUE;
        int OccasionalBird = 0;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() > OccasionalBirdValue) {
                OccasionalBirdValue = entry.getValue();
                OccasionalBird = entry.getKey();
            } else if (entry.getValue() == OccasionalBirdValue) {
                if (entry.getKey() < OccasionalBird) {
                    OccasionalBirdValue = entry.getKey();
                }
            }
        }

        return OccasionalBird;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = migratoryBirds(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
