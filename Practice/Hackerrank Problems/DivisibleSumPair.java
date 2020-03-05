import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the divisibleSumPairs function below.
    static int divisibleSumPairs(int n, int k, int[] ar) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i=0; i<ar.length; i++) {
            int mod = ar[i] % k;
            int need = (k - mod) % k;
            

            if (map.containsKey(need)) {
                System.out.println("need : " + need + " => " + map.get(need)); 
                count += map.get(need);
            }    

            if (map.containsKey(mod)) {
                map.put(mod, map.get(mod) + 1);
            } else {
                map.put(mod, 1);
            }
        }

        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = divisibleSumPairs(n, k, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
