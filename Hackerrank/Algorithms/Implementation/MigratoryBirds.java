import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static int migratoryBirds(int n, int[] ar) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i=0;i<ar.length; i++){
            if(map.containsKey(ar[i])){
                map.put(ar[i], map.get(ar[i]) + 1);
            }else{
                map.put(ar[i], 1);
            }
        }
        
        Object[] a = map.entrySet().toArray();
        Arrays.sort(a, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Map.Entry<String, Integer>) o2).getValue()
                    .compareTo(((Map.Entry<String, Integer>) o1).getValue());
            }
        });
        int first = 0;
        for (Object e : a) {
            first = ((Map.Entry<Integer, Integer>) e).getKey();
            break;
        }
        return first;
    }
   
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = migratoryBirds(n, ar);
        System.out.println(result);
    }
}
