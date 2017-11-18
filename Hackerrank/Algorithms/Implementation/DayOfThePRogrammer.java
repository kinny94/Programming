import java.io.*;
import java.util.*;
public class Solution {
    static boolean solve(int year){ 
        boolean x=false;
        if(year>1918)
            x=((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0));
        else
            x=(year%4==0);
        return x;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int year = in.nextInt();
        if(year==1918)
            System.out.println("26.09.1918");
        else if(solve(year))
            System.out.println("12.09."+year);
        else
            System.out.println("13.09."+year);
    }
}