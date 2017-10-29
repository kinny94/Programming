import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BreakingTheRecords{

    static int[] getRecord(int[] s){
        
        int[] result = new int[2];
        // Complete this function
        int highestCountBreak = 0;
        int lowestCountBreak = 0;
        
        int highest = s[0];
        for(int i=1; i<s.length; i++){
            if(s[i] > highest ){
                highest = s[i];
                highestCountBreak++;
            }
        }
        
        int lowest = s[0];
        for(int i=1; i<s.length; i++){
            if(s[i] < lowest){
                lowest = s[i];
                lowestCountBreak++;
            }
        }
        
        result[0] = highestCountBreak;
        result[1] = lowestCountBreak;
        
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] s = new int[n];
        for(int s_i=0; s_i < n; s_i++){
            s[s_i] = in.nextInt();
        }
        int[] result = getRecord(s);
        String separator = "", delimiter = " ";
        for (Integer val : result) {
            System.out.print(separator + val);
            separator = delimiter;
        }
        System.out.println("");
    }
}
