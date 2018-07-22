import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


/*
You are given an array of N integers.  The array is sorted and increasing,
but it is "circular", meaning that the least element in the array is not
necessarily at offset 0.  For instance, these are all valid arrays:

int array1[] = { 124, 150, 178, 14, 19, 80 };
int array2[] = { 15, 0, 1, 5, 12 };
int array3[] = { 0, 1, 2, 3, 4, 5 };

Write a function to find the value of the smallest element in the array:
*/


public class CircularArraySmallest {

    // public static int smallest( int[] a ){
        
    //     int min = Integer.MAX_VALUE;
        
    //     for( int i=0; i<a.length; i++ ){
    //         if( a[i] < min ){
    //             min = a[i];
    //         }
    //     }
        
    //     return min;
    // }
    
    public static int optimizeSolution( int [] a, int low, int high ){
        
        if ( high < low ) return a[0];
        
        if ( high == low ) return a[low];
        
        // finding middle element
         int mid = ( high + low )/2;
        
        if( mid < high && a[mid + 1] < a[mid] ){
            return a[ mid + 1 ];    
        }
        
        if( mid > low  && a[mid] < a[mid - 1] ){
            return a[mid];
        }
        
        if( a[high] > a[mid] ){
            return optimizeSolution( a, low, mid - 1 );
        }
        
        return optimizeSolution( a, mid+1, high);
       
    }
    
    
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT  */
        int array1[] = { 124, 150, 178, 14, 19, 80 };
        int array2[] = { 15, 0, 1, 5, 12 };
        int array3[] = { 0, 1, 2, 3, 4, 5 };
        
        System.out.println( optimizeSolution( array1, 0, array1.length-1 ) );
        System.out.println( optimizeSolution( array2, 0, array2.length-1 ) );
        System.out.println( optimizeSolution( array3, 0, array3.length-1 ) );
                
    }
}