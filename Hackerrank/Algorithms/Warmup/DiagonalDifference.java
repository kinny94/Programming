import java.io.*;
import java.util.*;

public class DiagonalDifference {

    public static void main(String[] args) {
        
        Scanner scan =  new Scanner(System.in);
        int matrixLength = scan.nextInt();
        
        int[][] matrix = new int[matrixLength][matrixLength];
        for(int i =0 ;i<matrixLength; i++){
            for(int j=0; j<matrixLength; j++){
                matrix[i][j] = scan.nextInt();
            }
        }
        
        int primaryDiagonal = 0;
        int secondaryDiagonal = 0;
        
        for(int i=0; i<matrixLength; i++){
            for(int j=0; j<matrix.length; j++){
                if(i == j){
                    primaryDiagonal += matrix[i][j];
                }
                
                if(i + j == matrixLength - 1){
                    secondaryDiagonal += matrix[i][j];
                }
            }
        }
        
        
        int difference = primaryDiagonal - secondaryDiagonal;
        
        if(difference < 0){
            difference *= -1;
        }
        
        System.out.println(difference);
       
    }
}