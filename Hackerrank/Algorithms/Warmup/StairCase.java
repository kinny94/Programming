import java.io.*;
import java.util.*;

public class StairCase {

    public static void main(String[] args) {
        
        Scanner scan =  new Scanner(System.in);
        int n = scan.nextInt();
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i + j >= n-1){
                    System.out.print("#");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}