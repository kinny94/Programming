import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class BirthdayChocolate {

    static int solve(int n, int[] s, int d, int m){
        int startingIndex =0;
        int result =0;
        int total = 0;
        
        for(int i=0;i<n;i++){
            startingIndex = i;
            
            try{
            for(int j=0;j<m;j++){
                total += s[startingIndex + j];
            }   
            }catch(Exception e){
                break;
            }
            
            if(total == d){
                result++;
            }
            total =0;
        }
        return result;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] s = new int[n];
        for(int s_i=0; s_i < n; s_i++){
            s[s_i] = in.nextInt();
        }
        int d = in.nextInt();
        int m = in.nextInt();
        int result = solve(n, s, d, m);
        System.out.println(result);
    }
}
