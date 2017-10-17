import java.io.*;
import java.util.*;
import java.text.*;

public class PlusMinus {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scan.nextInt();
        }
        
        int positive = 0;
        int negative = 0;
        int zeros = 0;
        
        for( int i=0; i<n; i++){
            if(arr[i] > 0){
                positive++;
            }
            
            if(arr[i] == 0){
                zeros++;
            }
            
            if(arr[i] < 0){
                negative++;
            }
        }
        
        float posResult = (float) positive / n;
        float zeroResult = (float) zeros / n;
        float negativeResult = (float) negative / n;
        //System.out.println(posResult);
        DecimalFormat df = new DecimalFormat("##0.000000");
        System.out.println(df.format(posResult));
        System.out.println(df.format(negativeResult));
        System.out.println(df.format(zeroResult));
    }
}