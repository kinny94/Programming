import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class DivisibleSumPair {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        int count = 0;
        for(int a_i=0; a_i < n; a_i++){
            int num = in.nextInt();
            int remainder = num % k;
            int complement = (remainder==0)?k:remainder;
            count += a[k - complement];
            a[remainder]++;
        }
        System.out.println(count);
    }
}