import java.util.ArrayList;
import java.util.Scanner;

class PixuredHard{
    

    public int solution(int[] a, int[] b){
        
        int number_of_elements = a.length;
        double c[] = new double[number_of_elements];
        ArrayList<ArrayList> pairs = new ArrayList<>();
    
        for(int i=0; i<number_of_elements; i++){
            c[i] =  ( b[i] / (double) 1000000);
        }

        for(int i=0; i<number_of_elements; i++){
            System.out.print(c[i] + " | ");
        }

        for(int i=0; i<number_of_elements; i++){
            
        }

        return 0;
    }


    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        System.out.println("How any elements?");
        int number_of_elements  = scan.nextInt();

        int a[] = new int[number_of_elements];
        int b[] = new int[number_of_elements];

        System.out.println("Enter elements for Array 1");
        for( int i=0; i<number_of_elements; i++ ){
            a[i] = scan.nextInt();
        }

        System.out.println("Enter elements for Array 2");
        for( int i=0; i<number_of_elements; i++ ){
            b[i] = scan.nextInt();
        }

        PixuredHard obj = new PixuredHard();
        obj.solution(a, b);
    }
}