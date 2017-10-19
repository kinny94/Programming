import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void result(int[] arr){
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        for(int i=0; i<arr.length; i++){
            list.add(arr[i]);
        }
        
        Collections.sort(list);
        
        long maxSum = 0;
        long minSum = 0;
        for(int i=1; i<list.size(); i++){
            maxSum += (long) list.get(i);           
        }
        
        for(int i=0; i<list.size()-1; i++){
            minSum += (long) list.get(i);           
        }
        
        System.out.print(minSum + " " + maxSum);
        
    } 
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[5];
        for(int arr_i=0; arr_i < 5; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        
        result(arr);
    }
}
