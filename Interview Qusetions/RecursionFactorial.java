import java.util.Scanner;

public class RecursionFactorial{
    
    public static int factorial(int number){
        if(number <= 1){
            return 1;
        }else{
            return number * factorial(number - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println(factorial(n));
    }
}