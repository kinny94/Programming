import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class GradingStudents {

    static int[] solve(int[] grades){
        for(int i = 0; i<grades.length; i++){
            if(grades[i] >= 38){
                int nearestRoundOff = grades[i];
                while(nearestRoundOff%5 != 0){
                    ++nearestRoundOff;
                }
                if(nearestRoundOff - grades[i] < 3){
                    grades[i] = nearestRoundOff;
                }
            }
        }
        return grades;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] grades = new int[n];
        for(int grades_i=0; grades_i < n; grades_i++){
            grades[grades_i] = in.nextInt();
        }
        int[] result = solve(grades);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");
        

    }
}
