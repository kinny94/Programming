import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String in) {
        String[] time_split = in.split(":");
        String hr = time_split[0];
        int hr_int = Integer.parseInt(hr);
        String ampm = time_split[2];
        String ampmc = Character.toString(ampm.charAt(2));
        if(ampmc.equals("P")&& hr_int!=12 ){
            int hr1= Integer.parseInt(hr)+12;
            hr=""+hr1; 
        }else if(ampmc.equals("A")&& hr_int==12){
            hr="00";
        }
        return hr+":"+time_split[1]+":"+Character.toString(ampm.charAt(0))
                       +Character.toString(ampm.charAt(1));
    }
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
