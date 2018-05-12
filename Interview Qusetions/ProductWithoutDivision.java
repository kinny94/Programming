import java.util.Scanner;

public class ProductWithoutDivision{

    public static void productArray( int[] a, int n ){
        int i;
        int temp = 1;
        int prod[] = new int[n];

        // Inititalizing the array as 1
        for( int j=0; j<n; j++ ){
            prod[j] = 1;
        }

        /* temp variable will contain product of elements on the left side */
        for( i=0; i<n; i++ ){
            prod[i] = temp;
            temp *= a[i];
        }

        //Initiaize temp to 1 again
        temp = 1;

        /* temp variable will contain product of elements on the right side  */
        for( i=n-1; i>=0; i-- ){
            prod[i] *= temp;
            temp *= a[i];
        }

        for( i =0; i<n; i++ ){
            System.out.print(  prod[i] + " ");
        }

        return;

    }

    public static void main(String[] args) {
        int a[] = new int[5];
        Scanner scan = new Scanner( System.in );
        for( int i=0; i<5; i++ ){
            a[i] = scan.nextInt();
        }

        int n = a.length;
        productArray(a, n);
    }
}